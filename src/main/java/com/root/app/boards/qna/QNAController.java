package com.root.app.boards.qna;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.boards.notice.NoticeDTO;
import com.root.app.pages.Pager;
import com.root.app.users.UserDTO;

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
	public ModelAndView getDetail(QNADTO qnadto, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("boardhit");
		boolean check = false;
		
		if(obj != null) {
			HashSet<Long> ar = (HashSet<Long>)obj;
			if(!ar.contains(qnadto.getBoardNum())) {
				ar.add(qnadto.getBoardNum());
				check=true;
			}
			
		} else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(qnadto.getBoardNum());
			session.setAttribute("boardhit", num);	
			check=true;
		}
		
		qnadto = qnaService.getDetail(qnadto, check);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto",qnadto);
		modelAndView.setViewName("qna/detail");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public ModelAndView add(HttpSession session) throws Exception {
			
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");

		} else {
			modelAndView.setViewName("qna/add");
		}
		
		return modelAndView;
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
	public ModelAndView update(QNADTO qnadto, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");

		} else {
		
		modelAndView.addObject("qna", qnaService.getDetail(qnadto, false));
		modelAndView.setViewName("qna/update");
		}
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
	public ModelAndView delete(QNADTO qnadto, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");

		} else {
			int result = qnaService.delete(qnadto);
			
			if(result > 0) {
				modelAndView.addObject("result","삭제성공");
				modelAndView.addObject("path", "./list");
			} else {
				modelAndView.addObject("result","삭제실패");
				modelAndView.addObject("path", "./detail");
			}
			modelAndView.setViewName("commons/result");
		}
		
		return modelAndView;
	}
}
