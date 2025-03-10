package com.root.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDownView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("fileDowmView");
//		Iterator<String> it = model.keySet().iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		FileDTO fileDTO = (FileDTO)model.get("file");
		String path = (String)model.get("kind");
		path = request.getSession().getServletContext().getRealPath("/resources/images/"+path+"/");
		
		File file = new File(path,fileDTO.getFileName());
		//�ѱ� ���ڵ�ó��
		//�������ڵ��ߴٸ� ��������
		response.setCharacterEncoding("UTF-8");
	
		//������ ũ��
		response.setContentLength((int)file.length());
		
		//�ٿ�ε��Ҷ� ���ϸ�����
		String name = fileDTO.getOldName();
		//���ڵ�����
		name = URLEncoder.encode(name, "UTF-8");
		//Ÿ���� ����� ���� 
		response.setHeader("Content-Disposition", "attachment;fileName=\""+name+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		OutputStream outputStream = response.getOutputStream();
		
		FileCopyUtils.copy(fileInputStream, outputStream);
		
		//�ڿ�����
		outputStream.close();
		fileInputStream.close();
	}
}
