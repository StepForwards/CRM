package com.forward.web.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.model.User;
import com.forward.service.UserService;
import com.forward.service.impl.UserServiceImpl;

public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String u_key = request.getParameter("u_key");
		String t_key = request.getParameter("t_key");
		List<User> list = us.selectUser(u_key,t_key);
		request.setAttribute("searchUser", list);
		request.getRequestDispatcher("/userManage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}