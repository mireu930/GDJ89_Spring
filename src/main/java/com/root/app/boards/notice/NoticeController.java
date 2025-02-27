package com.root.app.boards.notice;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.boards.BoardDTO;
import com.root.app.pages.Pager;
import com.root.app.users.UserDTO;
import com.root.app.users.UserService;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("kind")
	public String getKind() {
		return "Notice";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		List<BoardDTO> ar = noticeService.getList(pager);
			
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("pager", pager);
		modelAndView.addObject("list", ar);
		
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
		
		boardDTO = noticeService.getDetail(boardDTO, check);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", boardDTO);
		modelAndView.setViewName("board/detail");
		
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add() throws Exception {
		
		return "board/boardform";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BoardDTO boardDTO) throws Exception {

		int result = noticeService.add(boardDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./list");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(BoardDTO boardDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("board", noticeService.getDetail(boardDTO,false));
		modelAndView.setViewName("board/boardform");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update2(BoardDTO boardDTO) throws Exception {
		int result = noticeService.update(boardDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./detail?boardNum="+boardDTO.getBoardNum());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BoardDTO boardDTO, Model model) throws Exception {
		int result = noticeService.delete(boardDTO);
		
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
