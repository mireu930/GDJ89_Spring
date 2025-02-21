package com.root.app.accounts;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.users.UserDTO;

@Controller
@RequestMapping(value = "/accounts/*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(AccountDTO accountDTO, HttpSession session, Model model) throws Exception {
		System.out.println("acoountList");
//		ModelAndView modelAndView = new ModelAndView();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		String path ="";
		
		
		if(userDTO == null) {
			System.out.println(userDTO.getUser_name());
			model.addAttribute("result", "로그인이 필요합니다.");
			model.addAttribute("path", "redirect:/users/login");
			
			path = "commons/result";
		} else {
			accountDTO.setUser_name(userDTO.getUser_name());
			List<AccountDTO> ar = accountService.getList(accountDTO);
			model.addAttribute("list", ar);
			path = "accounts/list";
			
		}
		
		
		
		return path;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(AccountDTO accountDTO) throws Exception {
		accountDTO = accountService.getDetail(accountDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", accountDTO);
		modelAndView.setViewName("accounts/detail");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "accounts/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(AccountDTO accountDTO) throws Exception {
		int result = accountService.add(accountDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result>0) {
			modelAndView.setViewName("redirect:./list");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(AccountDTO accountDTO) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("account", accountService.getDetail(accountDTO));
		modelAndView.setViewName("accounts/update");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update2(AccountDTO accountDTO) throws Exception {
		int result = accountService.update(accountDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./detail?accountNum="+accountDTO.getAccountNum());
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(AccountDTO accountDTO, Model model) throws Exception {
		int result = accountService.delete(accountDTO);
		
		
		if(result>0) {
			model.addAttribute("result", "삭제성공");
			model.addAttribute("path", "./list");
		} else {
			model.addAttribute("result","삭제실패");
			model.addAttribute("path", "./detail");
		}
		
		return "commons/result";
	}
}
