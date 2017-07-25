package com.forward.web.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.model.Department;
import com.forward.model.Role;
import com.forward.model.User;
import com.forward.service.UserService;
import com.forward.service.impl.UserServiceImpl;

public class EditDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
	private String str;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String d_id = request.getParameter("d_id");
		String kind = request.getParameter("kind");
		int id = Integer.parseInt(d_id);
		switch (kind) {
		case "department": 
			Department department = (Department)us.selectKindInfo(kind,id);
			request.setAttribute("department", department);
			str = "/editDepartment.jsp";break;
		case "role": 
			Role role = (Role)us.selectKindInfo(kind,id);
			request.setAttribute("role", role);
			str = "/editRole.jsp";break;
		case "user": 
			User user = (User)us.selectKindInfo(kind,id);
			request.setAttribute("user", user);
			str = "/editUser.jsp";break;
		}		
		request.getRequestDispatcher(str).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}