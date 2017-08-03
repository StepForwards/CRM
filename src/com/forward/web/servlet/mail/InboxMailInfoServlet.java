package com.forward.web.servlet.mail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.model.Mail;
import com.forward.service.MailService;
import com.forward.service.impl.MailServiceImpl;

public class InboxMailInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService ms = new MailServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String m_id = request.getParameter("m_id");
		Mail mail = ms.selectInboxMailById(m_id);
		request.setAttribute("mail", mail);
		request.getRequestDispatcher("/WEB-INF/view/mail/inboxMailInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}