package com.forward.web.servlet.notice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.forward.model.Department;
import com.forward.model.Notice;
import com.forward.service.NoticeService;
import com.forward.service.UserService;
import com.forward.service.impl.NoticeServiceImpl;
import com.forward.service.impl.UserServiceImpl;

public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService ns = new NoticeServiceImpl();
	private UserService ds = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		Notice notice =  ns.selectNoticeById(id);
		List<Department> departmentList = ds.selectAllDepartment();
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/view/notice/updateNotice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Map<String, String[]> map = request.getParameterMap();
		Notice notice = new Notice();
		try {
			BeanUtils.populate(notice, map);
			ns.updateNoticeById(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/noticeList");
	}

}