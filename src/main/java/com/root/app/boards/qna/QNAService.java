package com.root.app.boards.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;
import com.root.app.boards.BoardService;
import com.root.app.boards.notice.NoticeDTO;
import com.root.app.pages.Pager;
import com.root.app.utils.FIle;

@Service
public class QNAService implements BoardService{
	@Autowired
	private QNADAO qnadao;
	@Autowired
	private FIle fIle;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnadao.getTotalCount(pager);
		
		pager.make(totalCount);
		pager.makeNum();
	
	return qnadao.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception {
		if(check) {
		qnadao.updatehit(boardDTO);
		}
		return qnadao.getDetail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO,HttpSession session, MultipartFile [] attaches) throws Exception {
		int result = qnadao.add(boardDTO);
		
		for(MultipartFile attache: attaches) {
			if(attache.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.save(attache, session.getServletContext());
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = qnadao.addFile(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile[] attaches, HttpSession session) throws Exception {
		return qnadao.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO, HttpSession session) throws Exception {
		
		boardDTO = qnadao.getDetail(boardDTO);
		
		int result = qnadao.deleteFileAll(boardDTO);
		result = qnadao.delete(boardDTO);
		
		if(result > 0) {
			String path = session.getServletContext().getRealPath("/resources/images/notice/");
			System.out.println(path);
			for(BoardFileDTO boardFileDTO:((QNADTO)boardDTO).getBoardFileDTOs()) {
				fIle.delete(path, boardFileDTO.getFileName());
			}
		}
		
		return result;
	}
	
	public int reply(QNADTO boardDTO) throws Exception {
		QNADTO parent = (QNADTO)qnadao.getDetail(boardDTO);

		boardDTO.setBoardRef(parent.getBoardRef());
		
		//부모의 step+1
		boardDTO.setBoardStep(parent.getBoardStep()+1);
		
		boardDTO.setBoardDepth(parent.getBoardDepth()+1);
		
		//step 업데이트
		int result = qnadao.updateStep(parent);
		
		result= qnadao.reply(boardDTO);
		
		
		return result;
	}
	
	private BoardFileDTO save(MultipartFile attach, ServletContext context) throws Exception {
		//어디에저장?
		String path = context.getRealPath("/resources/images/qna/");
		System.out.println(path);
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		//HDD저장
		fIle.file(path, attach);
		
		//파일정보를 DTO에 담아서 리턴
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		
		boardFileDTO.setFileName(fIle.getA());
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO, HttpSession session) throws Exception {
		boardFileDTO = qnadao.getFileDetail(boardFileDTO);
		
		int result = qnadao.deleteFile(boardFileDTO);
		
		if(result > 0) {
			String path = session.getServletContext().getRealPath("/resources/images/notice/");
			System.out.println(path);
			fIle.delete(path, boardFileDTO.getFileName());
		}
		
		return result;
	}
}
