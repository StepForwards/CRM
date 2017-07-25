package com.forward.web.servlet.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.forward.model.Department;
import com.forward.model.Role;
import com.forward.model.User;
import com.forward.service.UserService;
import com.forward.service.impl.UserServiceImpl;

public class UpdateDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new  UserServiceImpl();
	Department department = new Department();
	Role role = new Role();
	User user = new User();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String kind = request.getParameter("kind");
		Map<String, String[]> map = request.getParameterMap();
		
		try {
			switch(kind){		
			case "department": 
				BeanUtils.populate(department, map);
				us.updateKindInfo(kind,department);break;
			case "role": BeanUtils.populate(role, map);
				us.updateKindInfo(kind,role);break;
			case "user": BeanUtils.populate(user, map);
				us.updateKindInfo(kind,user);break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/selectAllDepartment");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}