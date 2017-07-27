<%@ page import="com.forward.service.impl.UserServiceImpl"
		import="com.forward.service.UserService"
		import="java.util.List"
		import="com.forward.model.Department"
		%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<m eta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
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
	<p style="font-size: 24px;">部门管理</p>
	<table style="background-color: #acacac; margin: 0 auto;">	
		<th bgcolor="orange">序号</th>
		<th bgcolor="orange">部门名称</th>
		<th bgcolor="orange">部门描述</th>
		<th bgcolor="orange">更新时间</th>
		<th bgcolor="orange">操作</th>
		<c:forEach items="${list }" var="list" varStatus="status">
			<tr bgcolor="orange">
				<td>${status.count }</td>
				<td>${list.d_name }</td>
				<td>${list.d_desc }</td>
				<td><fmt:formatDate value="${list.d_updatetime }" type="both" pattern="MM-dd HH:mm"/></td>
				<td><a class="fa fa-pencil" href="${pageContext.request.contextPath }/editKindInfo?d_id=${list.d_id }&kind=department"></a> | <a class="fa fa-remove" href="${pageContext.request.contextPath }/deleteKindInfo?d_id=${list.d_id }&kind=department"></a></td>
			</tr>
		</c:forEach>
	</table>
	<div style="margin-top: 50px "><button type="button" style="background-color: #3388FF;"><a href="${pageContext.request.contextPath }/addDepartment.jsp" style="text-decoration: none;">添加部门</a></button></button></div>
</div>	
</body>
</html>