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

public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
			
		String u_key = request.getParameter("u_key");
		String t_key = request.getParameter("t_key");
		
		if(u_key != null && t_key != null){
			request.getSession().setAttribute("u_key", u_key);
			request.getSession().setAttribute("t_key", t_key);
		}else{
			u_key = (String)request.getSession().getAttribute("u_key");
			t_key = (String)request.getSession().getAttribute("t_key");
		}
		
		int count = us.selectUserCountByKey(u_key,t_key);
		int totalPage = (count+10)/11;
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		List<User> list = us.selectUserLimitByKey(currentPage,11,u_key,t_key);
		PageInfo pif =  new PageInfo(currentPage, totalPage,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/userManage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}