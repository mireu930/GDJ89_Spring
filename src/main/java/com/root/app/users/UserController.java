package com.root.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void getDetail(UserDTO userDTO) throws Exception {
		userDTO = userService.getDetail(userDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("./mypage");
		
		
	}
}
