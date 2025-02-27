package com.root.app.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTest;
import com.root.app.boards.qna.QNADAO;
import com.root.app.boards.qna.QNADTO;

public class qnaDAOTest extends SampleTest {
	@Autowired
	private QNADAO qnadao;
	@Test
	public void getList() throws Exception {
		List<QNADTO> ar = qnadao.getList();
		
		assertNotEquals(0, ar.size());
	}

}
