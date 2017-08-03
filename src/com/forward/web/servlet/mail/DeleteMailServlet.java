package com.forward.web.servlet.mail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.service.MailService;
import com.forward.service.impl.MailServiceImpl;

public class DeleteMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService ms = new MailServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String m_id = request.getParameter("id");
		String status = "m_sendstatus";
		String m_sendstatus = request.getParameter("m_sendstatus");
		String m_receivestatus = request.getParameter("m_receivestatus");
		if(m_sendstatus == null){
			status = "m_receivestatus";
			ms.deleteSendMail(status,m_receivestatus,m_id);
		}else{
			ms.deleteSendMail(status,m_sendstatus,m_id);
		}
		
		
		response.sendRedirect(request.getHeader("referer"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}