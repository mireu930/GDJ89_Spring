package com.root.app.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.pages.Pager;

@Service
public class QNAService {
	@Autowired
	private QNADAO qnadao;
	
	public List<QNADTO> getList(Pager pager) throws Exception {
		Long totalCount = qnadao.gettotalcount(pager);
		
		pager.make(totalCount);
		pager.makeNum();
		
		return qnadao.getList(pager);
	}
	
	public QNADTO getDetail(QNADTO qnadto,  boolean check) throws Exception {
		if(check) {
			qnadao.updatehit(qnadto);
		}
		return qnadao.getDetail(qnadto);
	}
	
	public int add(QNADTO qnadto) throws Exception {
		return qnadao.add(qnadto);
	}
	public int update(QNADTO qnadto) throws Exception {
		return qnadao.update(qnadto);
	}
	public int delete(QNADTO qnadto) throws Exception {
		return qnadao.delete(qnadto);
	}
}
