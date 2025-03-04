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
		//1.DB�� notice������ Insert
		int result = noticeDAO.add(boardDTO);
		//2. HDD ������ �����ϰ� ���������� DB�� ����
		for(MultipartFile attache: attaches) {
		if(attache.isEmpty()) {
			continue;
		}
			BoardFileDTO boardFileDTO = this.save(attache, session.getServletContext());
			//DB����
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = noticeDAO.addFile(boardFileDTO);
			
		}
		
		
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.delete(boardDTO);
	}
	
	private BoardFileDTO save(MultipartFile attach, ServletContext context) throws Exception {
		//�������?
		String path = context.getRealPath("/resources/images/notice/");
		System.out.println(path);
		
		File file = new File(path);
		
		if(file.exists()) {
			file.mkdirs();
		}
		//HDD����
		fIle.file(path, attach);
		
		//���������� DTO�� ��Ƽ� ����
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		
		boardFileDTO.setFileName(fIle.getA());
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
	}
}

