package com.forward.web.servlet.mail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.service.MailService;
import com.forward.service.impl.MailServiceImpl;

public class DeleteInboxMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService ms = new MailServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String m_id = request.getParameter("id");
		String m_receivestatus = request.getParameter("m_receivestatus");
		ms.deleteInboxMail(m_receivestatus,m_id);
		response.sendRedirect(request.getContextPath()+"/inboxMailList?m_receivestatus=1");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}