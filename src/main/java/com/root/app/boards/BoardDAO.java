package com.root.app.boards;

import java.util.List;

import com.root.app.pages.Pager;

public interface BoardDAO {
	//list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	//add
	public int add(BoardDTO boardDTO) throws Exception;
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
	//totalCount
	public abstract Long getTotalCount(Pager pager) throws Exception;
	//updatehit
	public int updatehit(BoardDTO boardDTO) throws Exception;
}
