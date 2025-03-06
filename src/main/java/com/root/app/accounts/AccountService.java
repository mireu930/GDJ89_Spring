package com.root.app.accounts;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception {
		return accountDAO.getList(accountDTO);
	}
	
	public AccountDTO getDetail(AccountDTO accountDTO) throws Exception {
		return accountDAO.getDetail(accountDTO);
	}
	
	public int add(AccountDTO accountDTO) throws Exception {
		return accountDAO.add(accountDTO);
	}
	
	public int update(AccountDTO accountDTO) throws Exception {
		return accountDAO.update(accountDTO);
	}
	
	public int delete(AccountDTO accountDTO) throws Exception {
		return accountDAO.delete(accountDTO);
	}
	
	public int add2(List<AccountDTO> list) throws Exception {
		return accountDAO.add2(list);
	}
}
