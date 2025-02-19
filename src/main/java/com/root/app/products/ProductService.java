package com.root.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList() throws Exception {
		List<ProductDTO> ar = productDAO.getList();
		
		return ar;
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		
		int result = productDAO.add(productDTO);
		
		return result;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		productDTO = productDAO.getDetail(productDTO);
		
		return productDTO;
	}
}
