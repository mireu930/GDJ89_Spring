package com.root.app.accounts;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.root.app.accounts.AccountDAO.";
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", accountDTO);
	}
	
	public AccountDTO getDetail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", accountDTO);
	}	

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", accountDTO);
	}
	
	public int update(AccountDTO accountDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", accountDTO);
	}
	
	public int delete(AccountDTO accountDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", accountDTO);
	}
	
	public int add2(List<AccountDTO> list) throws Exception {
		return sqlSession.insert(NAMESPACE+"add2", list);
	}
}
