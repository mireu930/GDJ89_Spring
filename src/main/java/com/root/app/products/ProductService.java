package com.root.app.products;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.files.FileDTO;
import com.root.app.pages.Pager;
import com.root.app.utils.FIle;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private FIle fIle;
	@Value("${product.file.path}")
	private String path;
	
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
		
		ProductFileDTO productFileDTO = this.save(context, productFileImage, productDTO);

		
		result = productDAO.upload(productFileDTO);
		
		return result;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		productDTO = productDAO.getDetail(productDTO);
		
		return productDTO;
	}
	
	public int update(ProductDTO productDTO, MultipartFile productImage, HttpSession session) throws Exception {
		int result = productDAO.update(productDTO);
		
		if(productImage.isEmpty()) {
			return result;
		}
		
		ProductFileDTO productFileDTO = this.save(session.getServletContext(), productImage, productDTO);
				
		int result2 = productDAO.updateUpload(productFileDTO);
		
		if(result2<1) {
			result2 = productDAO.upload(productFileDTO);
		}
		
		productDTO = productDAO.getDetail(productDTO);
		session.setAttribute("dto", productDTO);
		
		return result;
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		int result = productDAO.delte(productDTO);
		
		return result;
	}
	
	private ProductFileDTO save(ServletContext context, MultipartFile productFileImage, ProductDTO productDTO) throws Exception {
		String path= context.getRealPath("/resources/images/products/");
		System.out.println(path);
		
		String f = fIle.file(path, productFileImage);
		
		System.out.println(productDTO.getProductNum());

		
		ProductFileDTO productFileDTO = new ProductFileDTO();
		productFileDTO.setProductNum(productDTO.getProductNum());
		productFileDTO.setFileName(f);
		productFileDTO.setOldName(productFileImage.getOriginalFilename());
		
		return productFileDTO;
	}
	
	public int getCommentsadd(CommentsDTO commentsDTO) throws Exception {
		return productDAO.getCommentsadd(commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception {
		
		Long totalCount = productDAO.getCommentCount(commentsDTO);
		
		pager.makeNum();
		pager.make(totalCount);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		
		return productDAO.getCommentList(map);
	}
	
	public int getCommentDelete(CommentsDTO commentsDTO) throws Exception {
		System.out.println("service"+commentsDTO.getBoardNum());
		return productDAO.getCommentDelete(commentsDTO);
	}
	
	public int getCommentUpdate(CommentsDTO commentsDTO) throws Exception {
		return productDAO.getCommentUpdate(commentsDTO);
	}
	
	public String detailFiles(HttpSession session, MultipartFile files)throws Exception{
		String path = session.getServletContext().getRealPath("/resources/images/products/");
		System.out.println(path);
		String fileName = fIle.file(path, files);
		System.out.println(fileName);
		return fileName;
		
	}
	
	public void deleteFile(FileDTO fileDTO, HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/images/products/");
		fIle.delete(path, fileDTO.getFileName());
	}
}
