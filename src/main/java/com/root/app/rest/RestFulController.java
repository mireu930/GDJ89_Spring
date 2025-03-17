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
		
		//Server에서 다른 서버로 요청
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		params.add("grant_type", "authorization_code");
		//restTemplate.getUriTemplateHandler();
		
		//요청객체생성
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String,String>>(null,null);
		
//		ResponseEntity<JSONDTO> res = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1",JSONDTO.class, req);
		//요청결과처리
		JSONDTO str = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JSONDTO.class, req);
		JSONDTO str2 = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts/1", req, JSONDTO.class);
		ResponseEntity<JSONDTO> r = restTemplate.exchange("url", HttpMethod.GET, req, JSONDTO.class);
		
//		JSONDTO str = res.getBody();
		
		//요청의결과를 dto에 담는데 dto가 여러개 나올경우
		List<JSONDTO> a = restTemplate.getForObject("url", List.class, req);
		
		System.out.println(str.getTitle());
	}
	
}
