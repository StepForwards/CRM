<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮件详情 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">

</head>
<body>
	<div class="box">
		<h3>邮件详情</h3>
		<form action="<c:url value=""/>" method="post">
			<table class="form-table">
				<tr>
					<td>发件人</td>
					<td colspan="3" >${mail.u_name }</td>
				</tr>
				<tr>
					<td>收件人</td>
					<td colspan="3" >${user.u_name }</td>
				</tr>
				<tr>
					<td>邮件主题</td>
					<td class="control">${mail.m_theme }</td>
				</tr>
				<tr>
					<td>邮件内容</td>
					<td colspan="3" class="control">${mail.m_content }</td>
				</tr>
				<tr>
					<td>发送时间</td>
					<td colspan="3" class="control">${mail.m_sendtime }</td>
				</tr>
			</table>
			<div class="buttons">
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>