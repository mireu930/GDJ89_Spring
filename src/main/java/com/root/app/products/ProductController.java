package com.root.app.products;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;
import com.root.app.pages.Pager;
import com.root.app.users.UserDTO;
import com.root.app.utils.FIle;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private FIle fIle;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("Product List");
		
		List<ProductDTO> ar = productService.getList(pager);
//		model.addAttribute("list", ar);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pager", pager);
		modelAndView.addObject("list", ar);
		
		modelAndView.setViewName("products/list");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(ProductDTO productDTO, HttpSession session) throws Exception {
		System.out.println("Prdocut Detail");
		
		ModelAndView modelAndView = new ModelAndView();
		
		productDTO = productService.getDetail(productDTO);
		
		session.setAttribute("dto", productDTO);

		modelAndView.addObject("dto", productDTO);
		modelAndView.setViewName("products/detail");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		System.out.println("product add");
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(ProductDTO productDTO, MultipartFile productImage, HttpSession session) throws Exception {
		 int result = productService.add(productDTO,productImage,session.getServletContext());
		System.out.println(productDTO.getProductName());
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./list");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(ProductDTO productDTO, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");
		} else if(!userDTO.getUser_name().equals("sss")){
			modelAndView.addObject("result", "관리자만 수정가능합니다.");
			modelAndView.addObject("path", "./detail?productNum="+productDTO.getProductNum());
			modelAndView.setViewName("commons/result");
		} else {
		
		modelAndView.addObject("dto", productService.getDetail(productDTO));
		modelAndView.setViewName("products/update");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update2(ProductDTO productDTO, MultipartFile productImage, HttpSession session) throws Exception {
		
		int result = productService.update(productDTO, productImage, session);
		
		ModelAndView modelAndView = new ModelAndView();
				
		if(result>0) {
			modelAndView.setViewName("redirect:./list");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ModelAndView delete(ProductDTO productDTO, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");
		} else if(!userDTO.getUser_name().equals("sss")){
			modelAndView.addObject("result", "관리자만 삭제가능합니다.");
			modelAndView.addObject("path", "./detail?productNum="+productDTO.getProductNum());
			modelAndView.setViewName("commons/result");
		} else {
			int result = productService.delete(productDTO);
			
			if(result>0) {
				modelAndView.setViewName("redirect:./list");
			}
		}
		
		return modelAndView;
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	
//	@RequestMapping(value = "addComments", method = RequestMethod.GET)
//	public void getCommentsadd(HttpSession session) throws Exception {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		if(userDTO == null) {
//			modelAndView.addObject("result", "로그인이 필요합니다.");
//			modelAndView.addObject("path", "/users/login");
//			modelAndView.setViewName("commons/result");
//
//		} else {
//			modelAndView.setViewName("board/boardform");
//		}
//		
//	}
	
	@RequestMapping(value = "addComments", method = RequestMethod.POST)
	public String getCommentsadd(CommentsDTO commentsDTO, HttpSession session, Model model) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		commentsDTO.setUser_name(userDTO.getUser_name());
		
		int result = productService.getCommentsadd(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajax";
	}
	
	@RequestMapping(value = "listComments", method = RequestMethod.GET)
	public String getCommentList(CommentsDTO commentsDTO, Pager pager, Model model) throws Exception {
		System.out.println("comments List");
		List<CommentsDTO> ar = productService.getCommentList(commentsDTO, pager);
		
		model.addAttribute("list", ar);
		
		return "commons/commentsList";
	}
	
	@RequestMapping(value = "deleteComments", method = RequestMethod.POST)
	public String getCommentDelete(CommentsDTO commentsDTO, Model model) throws Exception {
		System.out.println("deleteComment");
		System.out.println(commentsDTO.getBoardNum());
		
		int result = productService.getCommentDelete(commentsDTO);
		System.out.println(result);
		
		model.addAttribute("result", result);
		return "commons/ajax";
	}
	
	@RequestMapping(value = "updateComments", method = RequestMethod.POST)
	public String getCommentUpdate(CommentsDTO commentsDTO, Model model) throws Exception {
		System.out.println("updateComment");
		
		int result = productService.getCommentUpdate(commentsDTO);
		model.addAttribute("result", result);
		return "commons/ajax";
	}
	
	@RequestMapping(value = "detailFiles", method = RequestMethod.POST)
	public String detailFile(MultipartFile uploadFile, HttpSession session, Model model) throws Exception {
		System.out.println("detailFile");
		System.out.println(uploadFile.getOriginalFilename());
		
		String path = session.getServletContext().getRealPath("/resources/images/products/");
		System.out.println(path);
		
		File file = new File(path);
		
		fIle.file(path, uploadFile);
		
		String a =fIle.getA();
		System.out.println(a);
		
		String file2 = "/resources/images/products/"+a;
		
		model.addAttribute("result", file2);
		
		return "commons/ajax";
	}
}
