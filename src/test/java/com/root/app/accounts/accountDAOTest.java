package com.root.app.accounts;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTest;

public class accountDAOTest extends SampleTest{
	@Autowired
	private AccountDAO accountDAO;

//	@Test
	public void getList() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setUser_name("LEE1234");
		
		List<AccountDTO> ar = accountDAO.getList(accountDTO);
		
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void getDetail() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setAccountNum("20250221-161721");
		
		accountDTO = accountDAO.getDetail(accountDTO);
		
		assertNotNull(accountDTO);
	}
	
//	@Test
	public void add() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setAccountNum("20250221-162202");
		accountDTO.setProductNum(1L);
		accountDTO.setUser_name("LEE1234");
		
		int result = accountDAO.add(accountDTO);
		
		assertEquals(1, result);
	}
	
//	@Test
	public void update() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setProductNum(1L);
		accountDTO.setUser_name("LEE1234");
		accountDTO.setAccountsBalance(10L);
		accountDTO.setAccountNum("20250221-162202");
		
		int result = accountDAO.update(accountDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void delete() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setAccountNum("20250221-162202");
		
		int result = accountDAO.delete(accountDTO);
		
		assertEquals(1, result);
	}

}
