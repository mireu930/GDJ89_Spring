package com.root.app.users;

import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.carts.CartDTO;


@Controller
@RequestMapping(value = "/users/*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "check", method = RequestMethod.GET)
	public String check(UserDTO userDTO, Model model ) throws Exception {
		System.out.println(userDTO.getUser_name());
		System.out.println("아이디 중복체크");
		userDTO = userService.check(userDTO);
		//중복 0
		int result =0;
		
		if(userDTO== null) {
			result =1; //중복 x
		}
		
		model.addAttribute("result", result);
		
		return "commons/ajax";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() throws Exception {
		return "users/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public ModelAndView join(UserDTO userDTO, MultipartFile profile, HttpSession session) throws Exception{
		System.out.println(profile.getContentType());
		System.out.println(profile.getName());
		System.out.println(profile.getOriginalFilename());
		System.out.println(profile.getSize());
		System.out.println(profile.isEmpty());
		System.out.println(session.getServletContext());
		ModelAndView modelAndView = new ModelAndView();
		int result = userService.join(userDTO, profile, session.getServletContext());
//		 profile.getBytes();
//		if(result > 0) {
			modelAndView.setViewName("redirect:/");			
//		}
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserDTO userDTO, HttpSession session, Model model) throws Exception {
		userDTO = userService.login(userDTO);
		
		
		if(userDTO!=null) {
			session.setAttribute("user", userDTO);
			return "redirect:/";
		}
		model.addAttribute("result","로그인실패");
		model.addAttribute("path", "./login");

		return "commons/result";
	}
	
	@RequestMapping(value = "login", method =RequestMethod.GET)
	public String login() throws Exception {
		return "users/login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public UserDTO mypage(UserDTO userDTO, HttpSession session) throws Exception {
		return (UserDTO)session.getAttribute("user");
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(UserDTO userDTO, HttpSession session) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		 userDTO = (UserDTO)session.getAttribute("user");
		 
		modelAndView.addObject("user", userDTO);
		modelAndView.setViewName("users/update");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value ="update", method = RequestMethod.POST)
	public ModelAndView updateProcess(UserDTO userDTO, HttpSession session, MultipartFile profile)throws Exception {
		UserDTO sessionUser = (UserDTO)session.getAttribute("user");
		userDTO.setUser_name(sessionUser.getUser_name());
		int result = userService.update(userDTO, profile, session);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			session.setAttribute("user", userDTO);
			modelAndView.setViewName("redirect:./mypage");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ModelAndView delete(UserDTO userDTO, HttpSession session) throws Exception {
		System.out.println("userDelete");
		UserDTO sessionUser = (UserDTO)session.getAttribute("user");
		userDTO.setUser_name(sessionUser.getUser_name());
		
		ModelAndView modelAndView = new ModelAndView();
		
		int result = userService.delete(userDTO);
		System.out.println(result);
		if(result > 0) {
			session.setAttribute("user", null);
			modelAndView.addObject("result", "삭제성공");
			modelAndView.addObject("path", "/");
		} 
		
		modelAndView.setViewName("commons/result");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "addCart", method = RequestMethod.GET)
	public String cartAdd(Model model, CartDTO cartDTO, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO) session.getAttribute("user");

	    if (userDTO == null) {
	        model.addAttribute("result", "로그인이 필요합니다.");
	        return "commons/ajax";
	    }

	    
	    cartDTO.setUser_name(userDTO.getUser_name());
	    int result2 = userService.cartAdd(cartDTO);

	    String result = (result2 > 0) ? "장바구니 추가 성공" : "장바구니 추가 실패";
	    System.out.println(result);
	    model.addAttribute("result", result);
	    
	    return "commons/ajax";
	}
	
	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public String cartPage() {
	    return "users/cart";
	}

}
