package com.forward.web.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.model.Department;
import com.forward.model.Role;
import com.forward.service.impl.UserServiceImpl;

public class SelectRoDeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<Department> deList = us.selectAllDepartment();
		List<Role> roList = us.selectAllRole();
		request.setAttribute("deList", deList);
		request.setAttribute("roList", roList);
		request.getRequestDispatcher("/addUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
