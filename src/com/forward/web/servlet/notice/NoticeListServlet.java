package com.forward.web.servlet.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forward.model.Notice;
import com.forward.model.User;
import com.forward.service.NoticeService;
import com.forward.service.impl.NoticeServiceImpl;
import com.forward.tools.PageInfo;

public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService ns = new NoticeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获取当前用户
		User user = (User) request.getSession().getAttribute("user");
		
		//获取关键字和字段
		String noticeKeyWord = request.getParameter("noticeKeyWord");
		String noticeSearchField = request.getParameter("noticeSearchField");
		if(noticeKeyWord == null){
			noticeKeyWord = request.getSession().getAttribute("noticeKeyWord") == null ? "" : (String)request.getSession().getAttribute("noticeKeyWord");
			noticeSearchField = request.getSession().getAttribute("noticeSearchField") == null ? "n_theme" : (String)request.getSession().getAttribute("noticeSearchField");
		}
		request.getSession().setAttribute("noticeKeyWord", noticeKeyWord);
		request.getSession().setAttribute("noticeSearchField", noticeSearchField);
		
		//统计符合字段,关键字的记录
		int count = ns.selectNoticeCountByKey(user.getU_departmentid(),noticeKeyWord,noticeSearchField);
		
		//分页
		String page = request.getParameter("page");
		int currentPage = 1;
		if(page != null){
			currentPage = Integer.parseInt(page);
		}
		int pageSize = 15;
		int totalPage = (count + pageSize - 1) / pageSize;
		PageInfo pageInfo = new PageInfo(currentPage, totalPage, count, request.getContextPath()+request.getServletPath());
		
		//通过字段,关键字分页搜索
		List<Notice> noticeList = ns.selectNoticeByDepartmentId(user.getU_departmentid(),noticeSearchField,noticeKeyWord,currentPage,pageSize);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/WEB-INF/view/notice/noticeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}