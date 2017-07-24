<%@ page import="com.forward.service.impl.UserServiceImpl"
		import="com.forward.service.UserService"
		import="java.util.List"
		import="com.forward.model.User"
		%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>
	<p style="font-size: 24px;">用户列表</p>
	<form action="${pageContext.request.contextPath }/selectUser">
	<font>搜索内容: <input type="text" name="t_key" placeholder="请输入关键字"> 搜索字段:</font>
	<select name="u_key">
		<option value="u_name">用户名</option>
		<option value="u_department">部门</option>
		<option value="u_role">角色</option>
	</select>
		<input type="submit" value="搜索">	
	</form>
	
	<form action="${pageContext.request.contextPath }/addUser.jsp">
		<input type="submit" value="添加用户" style="background-color: #3388ff; float: right;">	
	</form>
	<table>	
		<th>序号</th>
		<th>用户名</th>
		<th>部门</th>
		<th>角色</th>
		<th>手机号</th>
		<th>邮箱</th>
		<th>更新时间</th>
		<th>操作</th>
		<% 	
			UserService us = new UserServiceImpl();
			List<User> list = us.selectUser();
			
			for(int i = 0; i < list.size(); i++){
				out.print("<tr>");
				out.print("<td>"+(i+1)+"</td>");		
				out.print("<td>"+list.get(i).getU_name()+"</td>");		
				out.print("<td>"+list.get(i).getU_departmentid()+"</td>");		
				out.print("<td>"+list.get(i).getU_roleid()+"</td>");		
				out.print("<td>"+list.get(i).getU_phone()+"</td>");		
				out.print("<td>"+list.get(i).getU_mail()+"</td>");		
				out.print("<td>"+list.get(i).getU_updatetime()+"</td>");		
				out.print("<td><a>编辑</a> <a>删除</a></td>");		
				out.print("</tr>");
			}	
		%>
	</table>
</body>
</html>