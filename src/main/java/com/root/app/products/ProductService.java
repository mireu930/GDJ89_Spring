package com.root.app.products;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.pages.Pager;
import com.root.app.utils.FIle;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private FIle fIle;
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
//		Pager pager = new Pager();
//		pager.setPage(page);
		Long totalCount = productDAO.gettotalcount(pager);
		
		pager.make(totalCount);
		pager.makeNum();
		List<ProductDTO> ar = productDAO.getList(pager);
		
		return ar;
	}
	
	public int add(ProductDTO productDTO, MultipartFile productFileImage, ServletContext context) throws Exception {
		
		int result = productDAO.add(productDTO);
		
		if(productFileImage.isEmpty()) {
			return result;
		}
		
		String path= context.getRealPath("/resources/images/products/");
		
		fIle.file(path, productFileImage);
		
		ProductFileDTO productFileDTO = new ProductFileDTO();
		productFileDTO.setProductNum(productDTO.getProductNum());
		productFileDTO.setFileName(fIle.getA());
		productFileDTO.setOldName(productFileImage.getOriginalFilename());
		
		result = productDAO.upload(productFileDTO);
		
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
