package com.root.app.accounts;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.products.ProductDTO;
import com.root.app.users.UserDTO;

@Controller
@RequestMapping(value = "/accounts/*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(AccountDTO accountDTO, HttpSession session) throws Exception {
		System.out.println("acoountList");
		ModelAndView modelAndView = new ModelAndView();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");

		} else {
			accountDTO.setUser_name(userDTO.getUser_name());
			List<AccountDTO> ar = accountService.getList(accountDTO);
			modelAndView.addObject("list", ar);
			modelAndView.setViewName("accounts/list");

		}
		
		
		
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
	public String add(Model model) throws Exception {
		model.addAttribute("path", "/products/list");
		return "commons/add_result";
	}
	
	@RequestMapping(value = "addProcess", method = RequestMethod.GET)
	public ModelAndView add(AccountDTO accountDTO, HttpSession session, Model model) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		ModelAndView modelAndView = new ModelAndView();
		ProductDTO productDTO = (ProductDTO)session.getAttribute("productDTO");
		
		accountDTO.setUser_name(userDTO.getUser_name());
		accountDTO.setAccountNum(accountNum().toString());
		accountDTO.setProductNum(productDTO.getProductNum());
		
		int result = accountService.add(accountDTO);
		
		if(result>0) {
			modelAndView.addObject("result", "추가되었습니다..");
			modelAndView.addObject("path", "./list");
			modelAndView.setViewName("commons/result");
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
	
	public StringBuilder accountNum()throws Exception {
		StringBuilder sb = new StringBuilder();
		Calendar calendar = Calendar.getInstance();
		sb.append(calendar.get(calendar.YEAR));
		sb.append(calendar.get(calendar.MONTH)+1);
		sb.append(calendar.get(calendar.DATE));
		sb.append("-");
		sb.append(calendar.get(calendar.HOUR_OF_DAY));
		sb.append(calendar.get(calendar.MINUTE));
		sb.append(calendar.get(calendar.SECOND));
		sb.append(calendar.get(calendar.MILLISECOND));
		
		return sb;
	}
}
