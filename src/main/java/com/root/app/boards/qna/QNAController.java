package com.root.app.boards.qna;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.notice.NoticeDTO;
import com.root.app.pages.Pager;
import com.root.app.users.UserDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QNAController {
	@Autowired
	private QNAService qnaService;
	
	//모든메서드에 넣어라
	@ModelAttribute("kind")
	public String getKind() {
		return "QnA";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		List<BoardDTO> ar = qnaService.getList(pager);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("list", ar);
		modelAndView.addObject("pager", pager);
		modelAndView.setViewName("board/list");
		
		return modelAndView;
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("boardhit");
		boolean check = false;
		
		if(obj != null) {
			HashSet<Long> ar = (HashSet<Long>)obj;
			if(!ar.contains(boardDTO.getBoardNum())) {
				ar.add(boardDTO.getBoardNum());
				check=true;
			}
			
		} else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(boardDTO.getBoardNum());
			session.setAttribute("boardhit", num);	
			check=true;
		}
		
		boardDTO = qnaService.getDetail(boardDTO, check);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto",boardDTO);
		modelAndView.setViewName("board/detail");
		
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
			modelAndView.setViewName("board/boardform");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BoardDTO boardDTO) throws Exception {

		int result = qnaService.add(boardDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./list");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(BoardDTO boardDTO, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");

		} else {
		
		modelAndView.addObject("board", qnaService.getDetail(boardDTO, false));
		modelAndView.setViewName("board/boardform");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update2(BoardDTO boardDTO) throws Exception {
		int result = qnaService.update(boardDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./detail?boardNum="+boardDTO.getBoardNum());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(BoardDTO boardDTO, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");

		} else {
			int result = qnaService.delete(boardDTO);
			
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
