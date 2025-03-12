package com.root.app.boards.notice;

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
import com.root.app.pages.Pager;
import com.root.app.utils.FIle;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FIle fIle;
	

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getTotalCount(pager);
		
		pager.make(totalCount);
		pager.makeNum();
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception {
		if(check) {
		noticeDAO.updatehit(boardDTO);
	}
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile [] attaches) throws Exception {
		//1.DB에 notice정보를 Insert
		int result = noticeDAO.add(boardDTO);
		//2. HDD 파일을 저장하고 그정보들을 DB에 저장
		for(MultipartFile attache: attaches) {
		if(attache.isEmpty()) {
			continue;
		}
			BoardFileDTO boardFileDTO = this.save(attache, session.getServletContext());
			//DB저장
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = noticeDAO.addFile(boardFileDTO);
			
		}
		
		
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile[] attaches, HttpSession session) throws Exception {
		int result = noticeDAO.update(boardDTO);
		
		for(MultipartFile attache: attaches) {
			if(attache.isEmpty()) {
				continue;
			}
				BoardFileDTO boardFileDTO = this.save(attache, session.getServletContext());
				//DB저장
				boardFileDTO.setBoardNum(boardDTO.getBoardNum());
				result = noticeDAO.addFile(boardFileDTO);
				
			}
		
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO, HttpSession session) throws Exception {
		
		boardDTO = noticeDAO.getDetail(boardDTO);
		
		int result = noticeDAO.fileDeleteAll(boardDTO);
		result = noticeDAO.delete(boardDTO);
		
		if(result > 0) {
			String path = session.getServletContext().getRealPath("/resources/images/notice/");
			System.out.println(path);
			for(BoardFileDTO boardFileDTO:((NoticeDTO)boardDTO).getBoardFileDTOs()) {
				System.out.println(path);
				fIle.delete(path, boardFileDTO.getFileName());				
			}
		}
		
		return result;
	}
	
	private BoardFileDTO save(MultipartFile attach, ServletContext context) throws Exception {
		//어디에저장?
		String path = context.getRealPath("/resources/images/notice/");
		System.out.println(path);
		
		File file = new File(path);
		
		if(file.exists()) {
			file.mkdirs();
		}
		//HDD저장
		String f = fIle.file(path, attach);
		
		//파일정보를 DTO에 담아서 리턴
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		
		boardFileDTO.setFileName(f);
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO, HttpSession session) throws Exception {
		boardFileDTO = noticeDAO.getFileDetail(boardFileDTO);
		
		int result = noticeDAO.fileDelete(boardFileDTO);
		
		if(result > 0) {
			String path = session.getServletContext().getRealPath("/resources/images/notice/");
			System.out.println(path);
			fIle.delete(path, boardFileDTO.getFileName());
		}
		
		return result;
	}
	
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return noticeDAO.getFileDetail(boardFileDTO);
	}
}

