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
import com.forward.tools.MyBeanUtils;


public class AddNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService ds = new UserServiceImpl();
	private NoticeService ns = new NoticeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		List<Department> departmentList = ds.selectAllDepartment();
		request.setAttribute("departmentList", departmentList);
		request.getRequestDispatcher("/WEB-INF/view/notice/addNotice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Map<String, String[]> map = request.getParameterMap();
		Notice notice = new Notice();
		
		try{
			MyBeanUtils.populate(notice, map);
			ns.addNotice(notice);
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/noticeList");
	}

}