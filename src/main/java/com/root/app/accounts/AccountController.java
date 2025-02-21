package com.root.app.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/accounts/*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(AccountDTO accountDTO) throws Exception {
		List<AccountDTO> ar = accountService.getList(accountDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("accounts/list");
		
		return modelAndView;
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
