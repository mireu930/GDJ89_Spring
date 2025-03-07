package com.root.app.accounts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.carts.CartDTO;
import com.root.app.users.UserDAO;
import com.root.app.users.UserDTO;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private UserDAO userDAO;
	
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
	
	public int add2(Long[] productNum, UserDTO userDTO) throws Exception {
		
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		
		for(Long num: productNum) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setProductNum(num);
			accountDTO.setUser_name(userDTO.getUser_name());
			accountDTO.setAccountNum(accountNum().toString());
			Thread.sleep(1000);
			
			list.add(accountDTO);
		}
		
		int result = accountDAO.add2(list);
		if(result>0) {
			List<CartDTO> list2 = new ArrayList<CartDTO>();
			
			for(Long num: productNum) {
				CartDTO cartDTO = new CartDTO();
				cartDTO.setProductNum(num);
				cartDTO.setUser_name(userDTO.getUser_name());
				
				list2.add(cartDTO);
			}
			
			userDAO.cartDelete(list2);			
		}
		
		return result;
	}
	
	public StringBuilder accountNum()throws Exception {
		StringBuilder sb = new StringBuilder();
		Calendar calendar = Calendar.getInstance();
		sb.append(calendar.get(calendar.YEAR));
		sb.append(calendar.get(calendar.MONTH)+1);
		sb.append(calendar.get(calendar.DATE));
		sb.append("-");
		sb.append(calendar.get(calendar.HOUR_OF_DAY));
		sb.append(calendar.get(calendar.MINUTE));
		sb.append(calendar.get(calendar.SECOND));
		sb.append(calendar.get(calendar.MILLISECOND));
		
		return sb;
	}
}
