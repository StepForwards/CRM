package com.forward.web.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.model.User;
import com.forward.service.UserService;
import com.forward.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autoLogin");
		u.setU_name(username);
		u.setU_pwd(password);
		u = us.login(u);
	
		if(u != null){
			request.getSession().setAttribute("user", u);
			if(autoLogin != null){
				Cookie userNameCookie = new Cookie("userName",u.getU_name());
				Cookie passwordCookie = new Cookie("password",u.getU_pwd());
				userNameCookie.setMaxAge(1000*60);
				passwordCookie.setMaxAge(1000*60);
				response.addCookie(userNameCookie);
				response.addCookie(passwordCookie);
			}
		
			response.sendRedirect(request.getContextPath()+"/admin.jsp");
		}else{
			request.getSession().setAttribute("state", "用户名或密码错误!");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}