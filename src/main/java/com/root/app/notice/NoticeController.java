package com.root.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView getDetail(NoticeDTO noticeDTO) throws Exception {
		noticeDTO = noticeService.getDetail(noticeDTO);
		
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
	public String update(NoticeDTO noticeDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("notice", noticeService.getDetail(noticeDTO));
		modelAndView.setViewName("notice/update");
		
		return "notice/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update2(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./list");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO, Model model) throws Exception {
		int result = noticeService.delete(noticeDTO);
		
		if(result > 0) {
			model.addAttribute("result","삭제성공");
			model.addAttribute("path", "./list");
		}
		
		return "commons/result";
	}
}
