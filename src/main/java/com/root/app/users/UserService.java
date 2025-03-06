package com.root.app.users;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.carts.CartDTO;
import com.root.app.pages.Pager;
import com.root.app.products.ProductDTO;
import com.root.app.utils.FIle;

@Service
public class UserService {
	@Autowired
	 private UserDAO userDAO;
	@Autowired
	 private FIle fIle;
	
	public int join(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception{
		int result = userDAO.join(userDTO);
		//1.어디에저장할건가?
		if(profile.isEmpty()) {
			return result;
		}

		UserFileDTO userFileDTO = this.save(context, profile, userDTO);
		result = userDAO.upload(userFileDTO);
		
		return result;//userDAO.join(userDTO);
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		UserDTO result = userDAO.getDetail(userDTO);
		if(result != null) {
			if(result.getPassword().equals(userDTO.getPassword())) {
				return result;
			}
		}
		return null;
	}
	
	public UserDTO check(UserDTO userDTO) throws Exception {
		return userDAO.getDetail(userDTO);
	}
	
	public int update(UserDTO userDTO, MultipartFile profile, HttpSession session) throws Exception {
		int result = userDAO.update(userDTO);
		System.out.println("result:"+result);
		System.out.println(profile);
		if(profile ==null ||profile.isEmpty()) {
			return result;
		}
		
		UserFileDTO userFileDTO = this.save(session.getServletContext(), profile, userDTO);
		
		int r = userDAO.uploadUpdate(userFileDTO);
		System.out.println("r:"+r);
		
		if(r<1) {
			r = userDAO.upload(userFileDTO);
		}
		
		userDTO = userDAO.getDetail(userDTO);
		System.out.println(userDTO.getUserFileDTO().getOldName());
		session.setAttribute("user", userDTO);
		System.out.println(session.getAttribute("user"));
		
		return result;
	}
	
	public int delete(UserDTO userDTO) throws Exception {
		return userDAO.delete(userDTO);
	}
	
	private UserFileDTO save(ServletContext context, MultipartFile profile, UserDTO userDTO) throws Exception {
		String path = context.getRealPath("/resources/images/profiles/");
		System.out.println(path);

		fIle.file(path, profile);

		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUser_name(userDTO.getUser_name());
		userFileDTO.setFileName(fIle.getA());
		userFileDTO.setOldName(profile.getOriginalFilename());
		
		return userFileDTO;
	}
	
	public int cartAdd(CartDTO cartDTO) throws Exception {
		return userDAO.cartAdd(cartDTO);
	}
	
	public List<ProductDTO> getCartList(Pager pager, Object userDTO)throws Exception{
		
		pager.make(userDAO.gettotalcount(userDTO));
		pager.makeNum();
		
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("user", userDTO);
		return userDAO.getCartList(map);
	}
	
	
}
