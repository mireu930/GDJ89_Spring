package com.root.app.utils;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FIle {
	
	public String file(String path, MultipartFile profile) throws Exception {
			File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. ������� ��̸����� ����??
		//   1)�ð�
//		Calendar ca = Calendar.getInstance();
//		long mil = ca.getTimeInMillis();//1234567
//		String f = profile.getOriginalFilename();
//		f = f.substring(f.lastIndexOf("."));
//		f = mil+f;
		
		//	2) ��ü ���
		String f = UUID.randomUUID().toString();
		f = f+"_"+profile.getOriginalFilename();
		
		
		
		//3. HDD�� ����
		//1) MultipartFile class�� transferTo �޼���
		file = new File(file, f);
//		profile.transferTo(file);
		
		//2) FileCopyUtils
		FileCopyUtils.copy(profile.getBytes(), file);		
		
		return f;
	}
	
	public void delete(String path, String fileName) throws Exception {
		File file = new File(path, fileName);
		
		boolean check = file.delete();
		
		
	}
}
