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
		//���Ͱ�ü�� �Ҹ�ɶ� ����(������ ����Ǳ� ���� �Ҹ�)
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		//��û�� �������� �����ϴ� ����
		System.out.println("��û�� �߻�");
		HttpServletRequest req = (HttpServletRequest)request;
		
		Object obj = req.getSession().getAttribute("user");
		
		if(obj!=null) {
		
		// pass the request along the filter chain
		//���������� doFilter�޼��� ȣ��
		//�������Ͱ� ���ٸ� dispatcherSevlet���� �̵�
		chain.doFilter(request, response);
		}
		
		//redirect 
//		HttpServletResponse res = (HttpServletResponse)response;
//		res.sendRedirect("/users/login");
		
		//foward
		req.setAttribute("result", "�α����� �ʿ��մϴ�");
		req.setAttribute("path", "/users/login");
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		//������ ������ �����ϴ� ����
		System.out.println("������ �߻�");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//���Ͱ�ü�� ó�� �����ɶ�
	}

}
