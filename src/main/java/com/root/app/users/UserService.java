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

@Service
public class UserService {
	@Autowired
	 private UserDAO userDAO;
	
	public int join(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception{
		int result = userDAO.join(userDTO);
		//1.어디에저장할건가?
		if(profile.isEmpty()) {
			return result;
		}
		String path = context.getRealPath("/resources/images/profiles/");
		System.out.println(path);
//		profile.getBytes();
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		//2.어떤파일을 어떤이름으로 저장?
		
		Calendar ca = Calendar.getInstance();
		 long mil = ca.getTimeInMillis();
		String a =profile.getOriginalFilename();
		a=a.substring(a.lastIndexOf("."));
		a=mil+a;
		
		//2)이름을 만드는 객체
//		String a = UUID.randomUUID().toString();
//		a = a +"_"+profile.getOriginalFilename();
		
		//3.HDD저장
			//1 transferTo
		file = new File(file,a);
		profile.transferTo(file); 
			//2 spring 라이브러리 제공하는 CopyUtils
//		FileCopyUtils.copy(profile.getBytes(), file);
		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUser_name(userDTO.getUser_name());
		userFileDTO.setFileName(a);
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
	
	public int update(UserDTO userDTO) throws Exception {
		return userDAO.update(userDTO);
	}
	
	public int delete(UserDTO userDTO) throws Exception {
		return userDAO.delete(userDTO);
	}
}
