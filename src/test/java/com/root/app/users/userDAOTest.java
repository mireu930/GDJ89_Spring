package com.root.app.users;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTest;

public class userDAOTest extends SampleTest {
	@Autowired
	private UserDAO userDAO;

//	@Test
	public void getDetail() throws Exception {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_name("LEE1234");
		
		userDTO = userDAO.getDetail(userDTO);
		
		assertNotNull(null, userDTO);
	}
	
//	@Test(expected = Exception.class)
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

//	@Test
	public void update() throws Exception {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setPassword("test");
		userDTO.setName("mireu");
		userDTO.setPhone("02-02-2222");
		userDTO.setEmail("mail");
		userDTO.setUser_name("LEE1234");
		
		
		int result = userDAO.update(userDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void delete() throws Exception {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_name("LEE1234");
		
		int result = userDAO.delete(userDTO);
		
		assertEquals(1, result);
	}
} 
