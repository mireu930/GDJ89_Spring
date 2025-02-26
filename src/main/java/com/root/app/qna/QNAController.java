package com.root.app.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.notice.NoticeDTO;
import com.root.app.pages.Pager;

@Controller
@RequestMapping(value = "/qna/*")
public class QNAController {
	@Autowired
	private QNAService qnaService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		List<QNADTO> ar = qnaService.getList(pager);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("list", ar);
		modelAndView.addObject("pager", pager);
		modelAndView.setViewName("qna/list");
		
		return modelAndView;
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(QNADTO qnadto) throws Exception {
		qnadto = qnaService.getDetail(qnadto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto",qnadto);
		modelAndView.setViewName("qna/detail");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add() throws Exception {
		
		return "qna/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(QNADTO qnadto) throws Exception {

		int result = qnaService.add(qnadto);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./list");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(QNADTO qnadto) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("qna", qnaService.getDetail(qnadto));
		modelAndView.setViewName("qna/update");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update2(QNADTO qnadto) throws Exception {
		int result = qnaService.update(qnadto);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./detail?boardNum="+qnadto.getBoardNum());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QNADTO qnadto, Model model) throws Exception {
		int result = qnaService.delete(qnadto);
		
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
