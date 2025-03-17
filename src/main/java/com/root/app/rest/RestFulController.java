package com.root.app.rest;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestFulController {
	
	@RequestMapping("/rest/t1")
	public void f1() throws Exception {
		
		//Server���� �ٸ� ������ ��û
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.add("grant_type", "authorization_code");
		//restTemplate.getUriTemplateHandler();
		
		//��û��ü����
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String,String>>(null,null);
		
//		ResponseEntity<JSONDTO> res = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1",JSONDTO.class, req);
		//��û���ó��
		JSONDTO str = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JSONDTO.class, req);
		JSONDTO str2 = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts/1", req, JSONDTO.class);
		ResponseEntity<JSONDTO> r = restTemplate.exchange("url", HttpMethod.GET, req, JSONDTO.class);
		
//		JSONDTO str = res.getBody();
		
		//��û�ǰ���� dto�� ��µ� dto�� ������ ���ð��
		List<JSONDTO> a = restTemplate.getForObject("url", List.class, req);
		
		System.out.println(str.getTitle());
	}
	
}
