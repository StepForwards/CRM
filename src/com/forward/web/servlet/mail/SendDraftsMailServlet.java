package com.forward.web.servlet.mail;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.forward.model.Mail;
import com.forward.model.User;
import com.forward.service.MailService;
import com.forward.service.UserService;
import com.forward.service.impl.MailServiceImpl;
import com.forward.service.impl.UserServiceImpl;

public class SendDraftsMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService ms = new MailServiceImpl();
	private UserService us = new UserServiceImpl();
	private Mail mail = new Mail();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String m_id = request.getParameter("m_id");
		Mail mail = ms.selectMailById(m_id);
		request.setAttribute("mail", mail);
		List<User> userList = us.selectAllUser();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/WEB-INF/view/mail/sendDraftsMail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(mail, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ms.sendDraftsMail(mail);
		response.sendRedirect(request.getContextPath()+"/draftsMailList");
	}

}