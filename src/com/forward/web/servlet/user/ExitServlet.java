package com.forward.web.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		/*
		 * 1.清除session中的数据
		 * 2.重定向到index.jsp
		 */
		request.getSession().invalidate();
		Cookie userNameCookie = new Cookie("userName",null);
		Cookie passwordCookie = new Cookie("password",null);
		userNameCookie.setMaxAge(0);
		passwordCookie.setMaxAge(0);
		response.addCookie(userNameCookie);
		response.addCookie(passwordCookie);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}