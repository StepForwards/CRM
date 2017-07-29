<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告内容 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>公告内容</h3>
		<form action="<c:url value=""/>" method="post">
			<table class="form-table">
				<tr>
					<td>发布时间
					<input type="hidden" name="n_id" value="${notice.n_id }">
					<input type="hidden" name="n_userid" value="${user.u_id }">
					</td>
					<td class="control">
						<fmt:formatDate  value="${notice.n_begintime }" type="both" pattern="YYYY-MM-dd"/>
					</td>
					<td>截止时间</td>
					<td class="control">
						<fmt:formatDate  value="${notice.n_endtime }" type="both" pattern="YYYY-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>主题</td>
					<td class="control">
						${notice.n_theme }
					</td>
					<td>通知范围</td>
					<td class="control">
						${notice.n_departmentid != 0 ? user.d_name : "全部" }
					</td>
				</tr>
				<tr>
					<td>内容</td>
					<td colspan="3" class="control">
						${notice.n_content }
					</td>
				</tr>
			</table>
			<div class="buttons">
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>