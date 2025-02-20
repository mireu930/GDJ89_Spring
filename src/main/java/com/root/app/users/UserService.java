package com.root.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	 private UserDAO userDAO;
	
	public int join(UserDTO userDTO) throws Exception{
		return userDAO.join(userDTO);
	}
	
	public UserDTO getDetail(UserDTO userDTO) throws Exception {
		return userDAO.getDetail(userDTO);
	}
}
