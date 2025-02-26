package com.root.app.qna;

import java.sql.Date;

public class QNADTO {

	private Long boardNum;
	private String boardTitle;
	private String boardContent;
	private String user_name;
	private Date boardDate;
	private Long boardHit;
	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public Long getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(Long boardHit) {
		this.boardHit = boardHit;
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
