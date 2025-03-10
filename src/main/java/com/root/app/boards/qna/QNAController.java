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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;
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
		return "qna";
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
		modelAndView.addObject("dto2",boardDTO);
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
	public ModelAndView add(BoardDTO boardDTO, HttpSession session, MultipartFile [] attaches) throws Exception {

		int result = qnaService.add(boardDTO,session, attaches);
		
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
		BoardDTO dbBoard = qnaService.getDetail(boardDTO, false);
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");

		} else if(!dbBoard.getUser_name().equals(userDTO.getUser_name())&&!userDTO.getUser_name().equals("sss")){
			modelAndView.addObject("result", "작성자만 수정가능합니다.");
			modelAndView.addObject("path", "./detail?boardNum="+boardDTO.getBoardNum());
			modelAndView.setViewName("commons/result");
		} else {
		
		modelAndView.addObject("dto2", qnaService.getDetail(boardDTO, false));
		modelAndView.setViewName("board/boardform");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update2(BoardDTO boardDTO, MultipartFile[] attaches, HttpSession session) throws Exception {
		int result = qnaService.update(boardDTO, attaches, session);
		
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
		BoardDTO dbBoard = qnaService.getDetail(boardDTO, false);
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");

		}else if(!dbBoard.getUser_name().equals(userDTO.getUser_name())&&!userDTO.getUser_name().equals("sss")){
			modelAndView.addObject("result", "작성자만 삭제가능합니다.");
			modelAndView.addObject("path", "./detail?boardNum="+boardDTO.getBoardNum());
			modelAndView.setViewName("commons/result");
		} else {
			int result = qnaService.delete(boardDTO, session);
			
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
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(@ModelAttribute("dto")BoardDTO boardDTO, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if(userDTO == null) {
			modelAndView.addObject("result", "로그인이 필요합니다.");
			modelAndView.addObject("path", "/users/login");
			modelAndView.setViewName("commons/result");
		}else {
			modelAndView.setViewName("board/boardform");			
		}
		
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(QNADTO boardDTO, HttpSession session) throws Exception {
		
		 UserDTO userDTO = (UserDTO)session.getAttribute("user");
		 
		 boardDTO.setUser_name(userDTO.getUser_name());
		 
		 int result = qnaService.reply(boardDTO);
		 System.out.println(result);
		 
		return "redirect:./list";
		
	}
	
	@RequestMapping(value = "fileDelete", method = RequestMethod.POST)
	public String fileDelete(BoardFileDTO boardFileDTO, HttpSession session, Model model) throws Exception {
		int result = qnaService.fileDelete(boardFileDTO, session);
		model.addAttribute("result", result);
		return "commons/ajax";
	}
	
	@RequestMapping(value = "fileDown", method = RequestMethod.GET)
	public String fileDown(BoardFileDTO boardFileDTO, Model model) throws Exception {
		boardFileDTO = qnaService.getFileDetail(boardFileDTO);
		model.addAttribute("file", boardFileDTO);
		return "fileDownView";
	}
}
