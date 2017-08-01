<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布公告 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>发布公告</h3>
		<form action="<c:url value="/addNotice"/>" method="post">
			<table class="form-table">
				<tr>
					<td>发布时间<input type="hidden" name="n_userid" value="${user.u_id }">
					</td>
					<td class="control">
						<input type="date" name="n_begintime" min="<fmt:formatDate value="${nowTime }" type="both" pattern="yyyy-MM-dd" />" >
					</td>
					<td>截止时间</td>
					<td class="control">
						<input type="date" name="n_endtime" min="<fmt:formatDate value="${nowTime }" type="both" pattern="yyyy-MM-dd" />" >
					</td>
				</tr>
				<tr>
					<td>主题</td>
					<td class="control">
						<input type="text" name="n_theme" placeholder="填写公告主题">
					</td>
					<td>通知范围</td>
					<td class="control">
						<select name="n_departmentid">
								<option value="0">全部</option>
							<c:forEach items="${departmentList }" var="department">
								<option value="${department.d_id }">${department.d_name }</option>	
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>内容</td>
					<td colspan="3" class="control">
						<textarea class="p100" name="n_content" placeholder="请填写公告内容"></textarea>
					</td>
				</tr>
			</table>
			<div class="buttons">
				<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>