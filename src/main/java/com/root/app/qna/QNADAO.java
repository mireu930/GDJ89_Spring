package com.root.app.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.root.app.notice.NoticeDTO;
import com.root.app.pages.Pager;

@Repository
public class QNADAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.root.app.qna.QNADAO.";
	
	public List<QNADTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public QNADTO getDetail(QNADTO qnadto) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", qnadto);
	}
	
	public Long gettotalcount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"gettotalcount", pager);
	}
	
	public int add(QNADTO qnadto) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", qnadto);
	}
	
	public int update(QNADTO qnadto) throws Exception {
		return sqlSession.update(NAMESPACE+"update", qnadto);
	}
	
	public int updatehit(QNADTO qnadto) throws Exception {
		return sqlSession.update(NAMESPACE+"updatehit", qnadto);
	}
	
	public int delete(QNADTO qnadto) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", qnadto);
	}
}
