<%@ page import="com.forward.service.impl.UserServiceImpl"
		import="com.forward.service.UserService"
		import="java.util.List"
		import="com.forward.model.User"
		%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户管理</title>
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
	<p style="font-size: 24px;">用户列表</p>
	<form action="${pageContext.request.contextPath }/selectUser">
	<font>搜索内容: <input type="text" name="t_key" placeholder="请输入关键字"> 搜索字段:</font>
	<select name="u_key">
		<option value="u_name">用户名</option>
		<option value="u_department">部门</option>
		<option value="u_role">角色</option>
	</select>
		<input type="submit" value="搜索" style="background-color: #3388ff;">
	</form>
	
	<form action="${pageContext.request.contextPath }/selectRoDe">
		<input type="submit" value="添加用户" style="background-color: #3388ff; margin: 20px auto;">	
	</form>
	<table bgcolor="#acacac" style="margin: 0px auto;">	
		<th bgcolor="orange">序号</th>
		<th bgcolor="orange">用户名</th>
		<th bgcolor="orange">部门</th>
		<th bgcolor="orange">角色</th>
		<th bgcolor="orange">手机号</th>
		<th bgcolor="orange">邮箱</th>
		<th bgcolor="orange">更新时间</th>
		<th bgcolor="orange">操作</th>
		<c:forEach items="${list }" var="list" varStatus="status">
			<tr bgcolor="orange">
				<td>${status.count }</td>
				<td>${list.u_name }</td>
				<td>${list.d_name }</td>
				<td>${list.r_name }</td>
				<td>${list.u_phone }</td>
				<td>${list.u_mail }</td>
				<td><fmt:formatDate value="${list.u_updatetime }" type="both" pattern="MM-dd HH:mm"/></td>
				<td><a class="fa fa-pencil" href="${pageContext.request.contextPath }/editKindInfo?d_id=${list.u_id }&kind=user"></a> | <a class="fa fa-remove" href="${pageContext.request.contextPath }/deleteKindInfo?d_id=${list.u_id }&kind=user"></a></td>
			</tr>
		</c:forEach>
		<c:forEach items="${searchUser }" var="lists">
			<tr bgcolor="orange">
				<td>${lists.u_id }</td>
				<td>${lists.u_name }</td>
				<td>${lists.u_departmentid }</td>
				<td>${lists.u_roleid }</td>
				<td>${lists.u_phone }</td>
				<td>${lists.u_mail }</td>
				<td><fmt:formatDate value="${list.u_updatetime }" type="both" pattern="MM-dd HH:mm"/></td>
				<td><a class="fa fa-pencil" href="${pageContext.request.contextPath }/editKindInfo?d_id=${list.u_id }&kind=user"></a> | <a class="fa fa-remove" href="${pageContext.request.contextPath }/deleteKindInfo?d_id=${list.u_id }&kind=user"></a></td>
			</tr>
		</c:forEach>

	</table>
	<%@ include file="/page.jsp" %>
</div>
</body>
</html>