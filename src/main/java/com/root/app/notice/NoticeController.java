package com.root.app.notice;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.users.UserDTO;
import com.root.app.users.UserService;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception {
		List<NoticeDTO> ar = noticeService.getList();
			
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("list", ar);
		
		modelAndView.setViewName("notice/list");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(NoticeDTO noticeDTO, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("boardhit");
		boolean check = false;
		
		if(obj != null) {
			HashSet<Long> ar = (HashSet<Long>)obj;
			if(!ar.contains(noticeDTO.getBoardNum())) {
				ar.add(noticeDTO.getBoardNum());
				check=true;
			}
			
		} else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(noticeDTO.getBoardNum());
			session.setAttribute("boardhit", num);	
			check=true;
		}
		
		noticeDTO = noticeService.getDetail(noticeDTO, check);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", noticeDTO);
		modelAndView.setViewName("notice/detail");
		
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add() throws Exception {
		
		return "notice/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(NoticeDTO noticeDTO) throws Exception {

		int result = noticeService.add(noticeDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./list");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(NoticeDTO noticeDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("notice", noticeService.getDetail(noticeDTO,false));
		modelAndView.setViewName("notice/update");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update2(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./detail?boardNum="+noticeDTO.getBoardNum());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO, Model model) throws Exception {
		int result = noticeService.delete(noticeDTO);
		
		if(result > 0) {
			model.addAttribute("result","삭제성공");
			model.addAttribute("path", "./list");
		} else {
			model.addAttribute("result","삭제실패");
			model.addAttribute("path", "./detail");
		}
		
		return "commons/result";
	}
}
