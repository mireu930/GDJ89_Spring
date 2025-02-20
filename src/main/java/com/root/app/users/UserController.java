package com.root.app.users;

import java.io.OutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
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
	public ModelAndView join(UserDTO userDTO) throws Exception{
		int result = userService.join(userDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:/");			
		}
		
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
	public String mypage(UserDTO userDTO, HttpSession session) throws Exception {
		
		
		return "users/mypage";
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(UserDTO userDTO, HttpSession session) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		 userDTO = (UserDTO)session.getAttribute("user");

		modelAndView.setViewName("users/update");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value ="update", method = RequestMethod.POST)
	public ModelAndView updateProcess(UserDTO userDTO, HttpSession session)throws Exception {
		UserDTO sessionUser = (UserDTO)session.getAttribute("user");
		
		int result = userService.update(sessionUser);
		
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(result);
		
		if(result > 0) {
			System.out.println("수정성공");
			session.setAttribute("user", sessionUser);
			modelAndView.setViewName("redirect:./mypage");
		}
		
		return modelAndView;
	}
}
