<%@ page import="com.forward.service.impl.UserServiceImpl"
		import="com.forward.service.UserService"
		import="java.util.List"
		import="com.forward.model.Role"
		%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
</head>
<body>
	<p style="font-size: 24px;">角色管理</p>
	<table>	
		<th>序号</th>
		<th>角色名称</th>
		<th>角色描述</th>
		<th>更新时间</th>
		<th>操作</th>
		<% 	
			UserService us = new UserServiceImpl();
			List<Role> list = us.selectRole();
			
			for(int i = 0; i < list.size(); i++){
				out.print("<tr>");
				out.print("<td>"+(i+1)+"</td>");		
				out.print("<td>"+list.get(i).getR_name()+"</td>");		
				out.print("<td>"+list.get(i).getR_desc()+"</td>");		
				out.print("<td>"+list.get(i).getR_updatetime()+"</td>");		
				out.print("<td><a>编辑</a> <a>删除</a></td>");		
				out.print("</tr>");
			}	
		%>
	</table>
	<div><button type="button"><a href="${pageContext.request.contextPath }/addRole.jsp" style="text-decoration: none;">添加角色</a></button></button></div>
</body>
</html>