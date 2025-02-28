package com.root.app.users;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
	@Autowired
	 private UserDAO userDAO;
	
	public int join(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception{
		//1.어디에저장할건가?
		String path = context.getRealPath("/resources/images/profiles/");
		System.out.println(path);
//		profile.getBytes();
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		};
		
		return 0;//userDAO.join(userDTO);
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		UserDTO result = userDAO.getDetail(userDTO);
		if(result != null) {
			if(result.getPassword().equals(userDTO.getPassword())) {
				return result;
			}
		}
		return null;
	}
	
	public int update(UserDTO userDTO) throws Exception {
		return userDAO.update(userDTO);
	}
	
	public int delete(UserDTO userDTO) throws Exception {
		return userDAO.delete(userDTO);
	}
}
