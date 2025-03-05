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
import org.springframework.web.multipart.MultipartFile;
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
		return "notice";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("노티스");
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
		
		System.out.println(modelAndView.getViewName());
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

		}else if(!userDTO.getUser_name().equals("sss")) {
			modelAndView.addObject("result", "관리자만 추가가능합니다.");
			modelAndView.addObject("path", "./list");
			modelAndView.setViewName("commons/result");
		}else {
		
			modelAndView.setViewName("board/boardform");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BoardDTO boardDTO, MultipartFile [] attaches, HttpSession session) throws Exception {

		int result = noticeService.add(boardDTO,session, attaches);
		
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

		}else if(!userDTO.getUser_name().equals("sss")) {
			modelAndView.addObject("result", "관리자만 수정가능합니다.");
			modelAndView.addObject("path", "./detail?boardNum="+boardDTO.getBoardNum());
			modelAndView.setViewName("commons/result");
		}else {
		
		modelAndView.addObject("dto", noticeService.getDetail(boardDTO,false));
		modelAndView.setViewName("board/boardform");
		}
		
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
	public ModelAndView delete(BoardDTO boardDTO, Model model,HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
		}else if(!userDTO.getUser_name().equals("sss")) {
			modelAndView.addObject("result", "관리자만 삭제가능합니다.");
			modelAndView.addObject("path", "./detail?boardNum="+boardDTO.getBoardNum());
		}else {
			int result = noticeService.delete(boardDTO);
			
			if(result > 0) {
				modelAndView.addObject("result","삭제성공");
				modelAndView.addObject("path", "./list");
			} else {
				modelAndView.addObject("result","삭제실패");
				modelAndView.addObject("path", "./detail");
			}
		}
		modelAndView.setViewName("commons/result");
		
		
		return modelAndView;
	}
}
