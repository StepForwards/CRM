package com.forward.web.servlet.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.service.NoticeService;
import com.forward.service.impl.NoticeServiceImpl;

public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService ns = new NoticeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String n_id = request.getParameter("id");
		ns.deleteNoticeById(n_id);
		request.getRequestDispatcher("/noticeList").forward(request, response);
		
		//response.sendRedirect(request.getContextPath()+"/noticeList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}