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

public class DustbinMailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MailService ms = new MailServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获得用户
		User user = (User) request.getSession().getAttribute("user");
		//获得发送状态
		String m_sendstatus = request.getParameter("m_sendstatus");
		//获得字段,关键字
		String mailKeyWord = request.getParameter("dustbinMailKeyWord");
		String mailSearchField = request.getParameter("dustbinMailSearchField");
		
		if(mailKeyWord == null){
			mailKeyWord = request.getSession().getAttribute("dustbinMailKeyWord") == null ? "" : (String)request.getSession().getAttribute("dustbinMailKeyWord");
			mailSearchField = request.getSession().getAttribute("dustbinMailSearchField") == null ? "m_theme" : (String)request.getSession().getAttribute("dustbinMailSearchField");
		}
		request.getSession().setAttribute("dustbinMailKeyWord", mailKeyWord);
		request.getSession().setAttribute("dustbinMailSearchField", mailSearchField);
		/*
		 * 分页
		 * 1.统计cont
		 * 
		 */
		
		int totalDataCount = ms.selectDustbinMailCount(user.getU_id(), mailKeyWord, mailSearchField);
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
		List<Mail> dustbinMailList =  ms.selectDustbinMailByKey(user.getU_id(),mailKeyWord,mailSearchField,m_sendstatus,currentPage);
		//收尾
		request.setAttribute("pageInfo",pageInfo);
		request.setAttribute("dustbinMailList", dustbinMailList);
		request.getRequestDispatcher("/WEB-INF/view/mail/dustbinMailList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}