package com.root.app.utils;

import java.io.File;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class FIle {
	private String a;
	

	public void file(String path, MultipartFile profile) throws Exception {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		//2.어떤파일을 어떤이름으로 저장?
		
		Calendar ca = Calendar.getInstance();
		 long mil = ca.getTimeInMillis();
		a =profile.getOriginalFilename();
		a=a.substring(a.lastIndexOf("."));
		a=mil+a;
		
		//2)이름을 만드는 객체
//		String a = UUID.randomUUID().toString();
//		a = a +"_"+profile.getOriginalFilename();
		
		//3.HDD저장
			//1 transferTo
		file = new File(file,a);
		profile.transferTo(file);
	}
	
	public String getA() {	
		return a;
	}
	
	public void setA(String a) {
		this.a = a;
	}
}
