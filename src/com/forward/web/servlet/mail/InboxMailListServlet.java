package com.forward.web.servlet.mail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.model.Mail;
import com.forward.model.User;
import com.forward.service.MailService;
import com.forward.service.impl.MailServiceImpl;
import com.forward.tools.PageInfo;

public class InboxMailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService ms = new MailServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获得用户
		User user = (User) request.getSession().getAttribute("user");
		//获得发送状态	request.getParameter("m_receivestatus")
		String m_receivestatus = "1";
		//获得字段,关键字
		String mailKeyWord = request.getParameter("mailKeyWord");
		String mailSearchField = request.getParameter("mailSearchField");
		if(mailKeyWord == null){
			mailKeyWord = request.getSession().getAttribute("inboxMailKeyWord") == null ? "" : (String)request.getSession().getAttribute("inboxMailKeyWord");
			mailSearchField = request.getSession().getAttribute("inboxMailSearchField") == null ? "m_theme" : (String)request.getSession().getAttribute("inboxMailSearchField");
		}
		request.getSession().setAttribute("inboxMailKeyWord", mailKeyWord);
		request.getSession().setAttribute("inboxMailSearchField", mailSearchField);
		/*
		 * 分页
		 * 1.统计cont
		 * 
		 */
		int totalDataCount = ms.selectReceiveMailCount(user.getU_id(), mailKeyWord, mailSearchField,m_receivestatus);
		int pageSize = 15;
		int totalPage = (totalDataCount + pageSize  - 1)/pageSize;
		String page = request.getParameter("page");
		int currentPage = 1;
		if(page != null){
			currentPage = Integer.parseInt(page);
		}
		String servletPath = request.getContextPath()+request.getServletPath();
		PageInfo pageInfo = new PageInfo(currentPage, totalPage, totalDataCount, servletPath);
		
		//分页查询
		List<Mail> inboxMailList =  ms.selectReceiveMailByKey(user.getU_id(),mailKeyWord,mailSearchField,m_receivestatus,currentPage);
		//收尾
		request.setAttribute("pageInfo",pageInfo);
		request.setAttribute("inboxMailList", inboxMailList);
		request.getRequestDispatcher("/WEB-INF/view/mail/inboxMailList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}