package com.root.app.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTest;

public class noticeDAOTest extends SampleTest{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	@Test
	public void getList() throws Exception {
		List<NoticeDTO> ar = noticeDAO.getList();
		
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getDetail() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(1L);
		noticeDTO = noticeDAO.getDetail(noticeDTO);
		
		assertNotNull(noticeDTO);
	}
	@Test
	public void add() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardTitle("머고");
		noticeDTO.setBoardContent("아무노래나일단틀어");
		noticeDTO.setUserName("sss");
		
		int result = noticeDAO.add(noticeDTO);
		
		assertEquals(1, result);
	}
	@Test
	public void update() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardTitle("머고");
		noticeDTO.setBoardContent("아무노래나일단틀어");
		noticeDTO.setBoardNum(3L);
		
		int result = noticeDAO.update(noticeDTO);
		
		assertEquals(1, result);
	}
	@Test
	public void delete() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();

		noticeDTO.setBoardNum(3L);
		
		int result = noticeDAO.delete(noticeDTO);
		
		assertEquals(1, result);
	}

}
