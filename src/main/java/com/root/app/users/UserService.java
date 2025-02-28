package com.root.app.users;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.utils.FIle;

@Service
public class UserService {
	@Autowired
	 private UserDAO userDAO;
//	 private FIle fIle;
	
	public int join(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception{
		int result = userDAO.join(userDTO);
		//1.어디에저장할건가?
		if(profile.isEmpty()) {
			return result;
		}
		String path = context.getRealPath("/resources/images/profiles/");
		System.out.println(path);
//		profile.getBytes();
//		
//		//2)이름을 만드는 객체
////		String a = UUID.randomUUID().toString();
////		a = a +"_"+profile.getOriginalFilename();
//		
//		//3.HDD저장	
		FIle fIle = new FIle();
		fIle.file(path, profile);
			//2 spring 라이브러리 제공하는 CopyUtils
//		FileCopyUtils.copy(profile.getBytes(), file);
		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUser_name(userDTO.getUser_name());
		userFileDTO.setFileName(fIle.getA());
		System.out.println(fIle.getA());
		userFileDTO.setOldName(profile.getOriginalFilename());
		
		result = userDAO.upload(userFileDTO);
		
		return result;//userDAO.join(userDTO);
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
	
	public int update(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception {
		int result = userDAO.update(userDTO);
		
		String path = context.getRealPath("/resources/images/profiles/");
//		fIle.file(path, profile);
		
		if(result>0) {
			
		}
		
		return result;
	}
	
	public int delete(UserDTO userDTO) throws Exception {
		return userDAO.delete(userDTO);
	}
}
