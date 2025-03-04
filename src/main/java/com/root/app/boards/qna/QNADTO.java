package com.root.app.boards.qna;

import java.sql.Date;
import java.util.List;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;

public class QNADTO extends BoardDTO {

	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
	private List<BoardFileDTO> boardFileDTOs;
	

	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	public Long getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(Long boardRef) {
		this.boardRef = boardRef;
	}
	public Long getBoardStep() {
		return boardStep;
	}
	public void setBoardStep(Long boardStep) {
		this.boardStep = boardStep;
	}
	public Long getBoardDepth() {
		return boardDepth;
	}
	public void setBoardDepth(Long boardDepth) {
		this.boardDepth = boardDepth;
	}
	
	
}
