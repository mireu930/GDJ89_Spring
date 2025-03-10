package com.root.app.utils;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FIle {
	private String a;
	
	
	public void file(String path, MultipartFile profile) throws Exception {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		//2.어떤파일을 어떤이름으로 저장?
		
//		Calendar ca = Calendar.getInstance();
//		 long mil = ca.getTimeInMillis();
//		a =profile.getOriginalFilename();
//		a=a.substring(a.lastIndexOf("."));
//		a=mil+a;
		
		//2)이름을 만드는 객체
		a = UUID.randomUUID().toString();
		a = a +"_"+profile.getOriginalFilename();
		
		//3.HDD저장
			//1 transferTo
		file = new File(file,a);
//		profile.transferTo(file);
		FileCopyUtils.copy(profile.getBytes(), file);
	}
	
	public String getA() {	
		return a;
	}
	
	public void setA(String a) {
		this.a = a;
	}
	
	public void delete(String path, String fileName) throws Exception {
		File file = new File(path, fileName);
		
		boolean check = file.delete();
		
		
	}
}
