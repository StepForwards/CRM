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
		
		div{
			margin: 0px auto;
		}
	</style>	
	<script type="text/javascript">
		function deleteConfirm(del) {
			var c = confirm("确定删除吗?");
			if(c == true){
				/* document.getElementById("del").href=""; */
				document.location="deleteKindInfo?d_id="+del+"&kind=user"; 
			}
		}
	</script>
</head>
<body>
<div style="width: 1000px; height: 800px; background-color: white; ">
	
	<div style="width: 800px;">
	<p style="font-size: 24px;">用户列表</p>
	<form action="${pageContext.request.contextPath }/selectUser" style="float: left;">
	<font>搜索内容: <input type="text" name="t_key" placeholder="请输入关键字" value="${t_key }"> 搜索字段:</font>
	<select name="u_key">
		<c:choose>
			<c:when test="${u_key == 'd_name' }">
				<option value="u_name">用户名</option>
				<option value="d_name"  selected="selected">部门</option>
				<option value="r_name">角色</option>	
			</c:when>
			<c:when test="${u_key == 'r_name' }">
				<option value="u_name">用户名</option>
				<option value="d_name">部门</option>
				<option value="r_name"  selected="selected">角色</option>	
			</c:when>
			<c:otherwise>
				<option value="u_name">用户名</option>
				<option value="d_name">部门</option>
				<option value="r_name">角色</option>	
			</c:otherwise>
		</c:choose>
		
	</select>
		<input type="submit" value="搜索" style="background-color: #3388ff;">
	</form>
	
	
	<form action="${pageContext.request.contextPath }/selectRoDe">
		<input type="submit" value="添加用户" style="background-color: #3388ff; margin-bottom: 10px; float: right;">	
	</form>
	
	<table bgcolor="#acacac" style="margin: 40px auto; width: 100%;">	
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
				<td>${status.count+(pageInfo.currentPage-1)*11  }</td>
				<td><a href="<c:url value="selectUserInfo"/>?u_id=${list.u_id}&kind=user" style="text-decoration: none;">${list.u_name }</a></td>
				<td>${list.d_name }</td>
				<td>${list.r_name }</td>
				<td>${list.u_phone }</td>
				<td>${list.u_mail }</td>
				<td><fmt:formatDate value="${list.u_updatetime }" type="both" pattern="YYYY-MM-dd HH:mm"/></td>
				<td><a class="fa fa-pencil" href="${pageContext.request.contextPath }/editKindInfo?d_id=${list.u_id }&kind=user"></a> 
					| <a id="del" onclick="deleteConfirm(${list.u_id })" class="fa fa-remove" href="#" ></a>
					<%-- href="${pageContext.request.contextPath }/deleteKindInfo?d_id=${list.u_id }&kind=user" --%>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/page.jsp" %>
	</div>
</div>
</body>
</html>