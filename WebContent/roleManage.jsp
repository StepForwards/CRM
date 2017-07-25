<%@ page import="com.forward.service.impl.UserServiceImpl"
		import="com.forward.service.UserService"
		import="java.util.List"
		import="com.forward.model.Role"
		%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>角色管理</title>
	<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
	<link rel="stylesheet" href="<c:url value="/css/main.css" />">
	<style>
		body{
			text-align: center;
		}
		div{
			margin: 100px auto;
		}
	</style>
</head>
<body>
<div style="width: 1000px; height: 800px; background-color: white; ">
	<p style="font-size: 24px;">角色管理</p>
	<table style="margin: 0 auto;" bgcolor="#acacac">	
		<th bgcolor="orange">ID</th>
		<th bgcolor="orange">角色名称</th>
		<th bgcolor="orange">角色描述</th>
		<th bgcolor="orange">更新时间</th>
		<th bgcolor="orange">操作</th>
		<c:forEach items="${list }" var="list">
			<tr bgcolor="orange">
				<td>${list.r_id }</td>
				<td>${list.r_name }</td>
				<td>${list.r_desc }</td>
				<td>${list.r_updatetime }</td>
				<td><a class="fa fa-pencil" href="${pageContext.request.contextPath }/editDepartment?d_id=${list.r_id }&kind=role"></a> | <a class="fa fa-remove" href="${pageContext.request.contextPath }/deleteKindInfo?d_id=${list.r_id }&kind=role"></a></td>
			</tr>
		</c:forEach>
	</table>
	<div><button type="button" style="background-color: #3388FF;"><a href="${pageContext.request.contextPath }/addRole.jsp" style="text-decoration: none;">添加角色</a></button></button></div>
</div>
</body>
</html>