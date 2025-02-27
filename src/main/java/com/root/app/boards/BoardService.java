package com.root.app.boards;

import java.util.List;

import com.root.app.pages.Pager;

public interface BoardService {

	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception;
	
	public int add(BoardDTO boardDTO) throws Exception;
	
	public int update(BoardDTO boardDTO) throws Exception;
	
	public int delete(BoardDTO boardDTO) throws Exception;
}
