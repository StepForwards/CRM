<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>写邮件 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
<script type="text/javascript">
	function send(ms) {
		ms.value = 1;
		document.getElementById("receive").value = 1;
	}
	function drafts(md) {
		md.value = 2;
	}
</script>
</head>
<body>
	<div class="box">
		<h3>写邮件</h3>
		<form action="<c:url value="/writeMail"/>" method="post">
			<table class="form-table">
				<tr>
					<td>收件人<input type="hidden" name="m_sendid" value="${user.u_id }">
					</td>
					<td colspan="3" >
						<select name="m_receiveid">
							<c:forEach items="${userList }" var="user"> 
								<option value="${user.u_id }" >${user.u_name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>主题</td>
					<td class="control">
						<input type="text" name="m_theme" placeholder="请填写邮件主题">
					</td>
				</tr>
				<tr>
					<td>内容</td>
					<td colspan="3" class="control">
						<textarea class="p100" name="m_content" placeholder="请填写邮件内容"></textarea>
					</td>
				</tr>
			</table>
			<div class="buttons">
				<input class="btn btn-primary va-bottom" type="submit" name="m_sendstatus" onclick="send(this)" value="发送">&nbsp;&nbsp;
				<input type="hidden" name="m_receivestatus" id="receive">
				<input class="btn btn-primary va-bottom" type="submit" name="m_sendstatus" onclick="drafts(this)" value="保存草稿">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>