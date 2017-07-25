package com.forward.web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.service.UserService;
import com.forward.service.impl.UserServiceImpl;

public class DeleteKindInfoServlet extends HttpServlet {
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
		us.deleteKindInfo(kind,id);
		switch(kind){
		case "department": str = "/selectAllDepartment";break;
		case "role": str = "/selectAllRole";break;
		case "user": str = "/selectAllUser";break;
		}
		response.sendRedirect(request.getContextPath()+str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}