package com.root.app.products;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTest;

public class productDAOTest extends SampleTest {
		
		@Autowired
		private ProductDAO productDAO;
		
//		@Test
		public void getDetailTest() throws Exception {
			System.out.println("getDetail Test");
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(1L);
			
			
			productDTO = productDAO.getDetail(productDTO);
			
			assertNotNull(productDTO);
		}
//		@Test
		public void getList() throws Exception {
			System.out.println("getList Test");
//			List<ProductDTO> ar = productDAO.getList();
			
//			assertNotEquals(0,ar.size());
		}
		
//		@BeforeClass
//		public static void bf() {
//			System.out.println("전체테스트 시작전");
//			
//		}
//		
//		@AfterClass
//		public static void af() {
//			System.out.println("전체테스트 종료후");
//			
//		}
//		
//		@Before
//		public static void fe() {
//			System.out.println("개별테스트실행전");
//			
//		}
		
//		@org.junit.After
//		public static void ae() {
//			System.out.println("개별테스트실행후");
//			
//		}
		
//		@Test(timeout = 1000)
//		@Test(expected = Exception.class)
		public void addTest() throws Exception {
			ProductDTO productDTO = new ProductDTO();
			Calendar calendar = Calendar.getInstance();
			
			for(int i=0; i<110;i++) {
			productDTO.setProductDate(new Date(calendar.getTimeInMillis()));
			productDTO.setProductDetail("productDetail"+i);
			productDTO.setProductName("productName"+i);
			
			double r = Math.random();
			int ri = (int)r*100;
			r= ri/100.0;
			
			productDTO.setProductRate((r));
			
			productDAO.add(productDTO);
			if(i%10==0) {
				Thread.sleep(500);
			}
			
			System.out.println("Finish");
		}
	}
		@Test
		public void count() throws Exception {
//			Long result = productDAO.gettotalcount();
			
			assertEquals(0, 0);
		}
}

