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
import com.forward.tools.PageInfo;

public class SelectAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		int count = us.selectUserCount();
		int totalPage = (count+10)/11;
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		List<User> list = us.selectUserLimit(currentPage,11);
		PageInfo pif =  new PageInfo(currentPage, totalPage,count,request.getContextPath()+request.getServletPath());
		
		request.setAttribute("pageInfo", pif);
		request.setAttribute("list", list);
		request.getSession().removeAttribute("t_key");
		request.getSession().removeAttribute("u_key");
		request.getRequestDispatcher("/userManage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}