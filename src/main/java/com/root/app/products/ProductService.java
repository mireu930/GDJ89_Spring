package com.root.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.pages.Pager;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
//		Pager pager = new Pager();
//		pager.setPage(page);
		Long totalCount = productDAO.gettotalcount();
		Long totalPage = totalCount /5;
		
		
		if(totalCount % 5 != 0) {
			totalPage++;
		}		
		
		pager.setTotalPage(totalPage);
		
		Long totalBlock = (long)Math.ceil(totalPage/5.0);
		
		Long curBlock = (long)Math.ceil(pager.getPage()/5.0);
		
		Long start = (curBlock-1)*5+1;
		Long end = curBlock*5;
		
		pager.setStart(start);
		pager.setEnd(end);
		
		if(totalBlock == curBlock) {
			pager.setEnd(totalPage);
			pager.setEndCheck(true);
		}
		
		pager.makeNum();
		List<ProductDTO> ar = productDAO.getList(pager);
		
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
	
	public int update(ProductDTO productDTO) throws Exception {
		int result = productDAO.update(productDTO);
		
		return result;
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		int result = productDAO.delte(productDTO);
		
		return result;
	}
}
