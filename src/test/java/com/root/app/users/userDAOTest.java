package com.root.app.users;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTest;

public class userDAOTest extends SampleTest {
	@Autowired
	private UserDAO userDAO;

	@Test
	public void getDetail() throws Exception {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_name("LEE1234");
		userDTO.setPassword("ABCD1234");
		
		userDTO = userDAO.getDetail(userDTO);
		
		assertNotNull(null, userDTO);
	}
	
	@Test
	public void joinTest() throws Exception {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_name("test");
		userDTO.setPassword("test");
		userDTO.setName("mireu");
		userDTO.setPhone("02-02-2222");
		userDTO.setEmail("mail");
		
//		int result = userDAO.join(userDTO);
		int result = 0;
		
		//¥‹¡§πÆ assert
		assertEquals(1, result);
	}

}
