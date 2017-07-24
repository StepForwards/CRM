package com.forward.web.servlet.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.forward.model.Role;
import com.forward.service.UserService;
import com.forward.service.impl.UserServiceImpl;

public class AddRoleServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new  UserServiceImpl();
	Role role = new Role();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(role, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		us.addRole(role);
		response.sendRedirect(request.getContextPath()+"/departmentManage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}