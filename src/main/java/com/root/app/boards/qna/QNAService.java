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
}
