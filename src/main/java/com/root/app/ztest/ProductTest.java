package com.root.app.ztest;

import com.root.app.products.ProductDAO;
import com.root.app.products.ProductDTO;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductName("4");
		productDTO.setProductDetail("aaaa");
		productDTO.setProductRate(1.1);
		
		try {
			int result = productDAO.add(productDTO);
			
			if(result>0) {
				System.out.println("����");
			} else {
				System.out.println("����");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
