package com.root.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.notice.NoticeDAO;
import com.root.app.users.UserDTO;

public class UserNameCheckInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		noticeDAO.getDetail(null);
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		
		String name = "";
		
		 BoardDTO boardDTO = (BoardDTO)modelAndView.getModel().get("dto2");
		if(!userDTO.getUser_name().equals(boardDTO.getUser_name())) {
			modelAndView.addObject("result", "작성자만 수정가능합니다");
			modelAndView.addObject("path", "./list");
			modelAndView.setViewName("commons/result");
		}
		// TODO Auto-generated method stub
//		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	
}
