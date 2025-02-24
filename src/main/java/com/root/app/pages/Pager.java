package com.root.app.pages;

public class Pager {
	private Long startNum;
	private Long lastNum;
	private Long page;
	private Long perPage;	
	
	public void makeNum() throws Exception {
		this.startNum = (getPage()-1)*getPerPage()+1;
		this.lastNum = getPage()*getPerPage();
	}
	
	public Long getPage() {
		if(page == null || page <1) {
			this.page =1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		if(perPage==null|| perPage<1) {
			this.perPage =5L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	
}
