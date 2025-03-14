package com.root.app.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//필터객체가 소멸될때 실행(서버가 종료되기 직전 소멸)
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		//요청이 들어왔을때 실행하는 영역
		System.out.println("요청이 발생");
		HttpServletRequest req = (HttpServletRequest)request;
		
		Object obj = req.getSession().getAttribute("user");
		
		if(obj!=null) {
		
		// pass the request along the filter chain
		//다음필터의 doFilter메서드 호출
		//다음필터가 없다면 dispatcherSevlet으로 이동
		chain.doFilter(request, response);
		}
		
		//redirect 
//		HttpServletResponse res = (HttpServletResponse)response;
//		res.sendRedirect("/users/login");
		
		//foward
		req.setAttribute("result", "로그인이 필요합니다");
		req.setAttribute("path", "/users/login");
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		//응답이 나갈때 실행하는 영역
		System.out.println("응답이 발생");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//필터객체가 처음 생성될때
	}

}
