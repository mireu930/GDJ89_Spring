package com.root.app.boards.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardService;
import com.root.app.pages.Pager;

@Service
public class QNAService implements BoardService{
	@Autowired
	private QNADAO qnadao;

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
	public int add(BoardDTO boardDTO) throws Exception {
		return qnadao.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnadao.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnadao.delete(boardDTO);
	}
}
