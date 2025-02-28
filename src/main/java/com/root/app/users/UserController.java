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


@Controller
@RequestMapping(value = "/users/*")
public class UserController {

	@Autowired
	private UserService userService;
	
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

}
