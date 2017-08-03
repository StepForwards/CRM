<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发件箱 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">

<script type="text/javascript">
		function deleteConfirm(m_id,page) {
			var c = confirm("确定删除吗?");
			if(c == true){
				document.location="deleteMail?id="+m_id+"&page="+page+"&m_sendstatus=3";
			}
		}
		function page(){
			document.getElementById("search").submit();
		}
</script>

</head>
<body>
	<div class="box">
		<h3>发件箱</h3>
		<div class="actions">
			<div>
				<form action="${pageContext.request.contextPath }/sendMailList">
					<input type="hidden" name="m_sendstatus" value="1">
					<font>搜索内容: <input type="text" name="sendMailKeyWord" placeholder="请输入关键字" value="${sendMailKeyWord }"> 搜索字段:</font>
					<select name="sendMailSearchField">
								<option selected="selected" value="m_theme" ${sendMailSearchField eq "m_theme" ? "selected" : ""}>主题</option>
								<option value="u_name" ${sendMailSearchField eq "m_receiveid" ? "selected" : ""}>收件人</option>
					</select>
					<input type="submit" value="搜索" id="search" class="btn btn-primary">
				</form>
			</div>
			<div>
				<a class="btn btn-primary" href="<c:url value="/writeMail"/>">写邮件</a>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>收件人</th>
                <th>主题</th>
                <th>发送时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="mail" items="${sendMailList }" varStatus="status">
            <tr>
                <td>${status.count + (pageInfo.currentPage - 1)*15 }</td>
                <td>${mail.u_name }</td>
                <td><a href="<c:url value="/mailInfo?m_id="/>${mail.m_id }">
						 	${mail.m_theme }
                </a></td>
                <td><fmt:formatDate value="${mail.m_sendtime }" type="both" pattern="YYYY-MM-dd HH:mm"/></td>
                 <td>
                	<a class="fa fa-remove" title="删除" onclick="deleteConfirm(${mail.m_id},${pageInfo.currentPage})" ></a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <%@ include file="/page.jsp" %>
	</div>
</body>
</html>