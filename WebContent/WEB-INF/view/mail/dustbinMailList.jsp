<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>垃圾箱 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">

<script type="text/javascript">
		function deleteConfirm(u_id,sendid,m_id,page) {
			var c = confirm("确定删除吗?");
			
			if(c == true){
				
				if(u_id == sendid){					
					document.location="deleteMail?id="+m_id+"&page="+page+"&m_sendstatus=4";
				}else{
					document.location="deleteMail?id="+m_id+"&page="+page+"&m_receivestatus=4";
				}
			}
		}
		function page(){
			document.getElementById("search").submit();
		}
</script>

</head>
<body>
	<div class="box">
		<h3>垃圾箱</h3>
		<div class="actions">
			<div>
				<form action="${pageContext.request.contextPath }/dustbinMailList">
					<input type="hidden" name="m_sendstatus" value="3">
					<input type="hidden" name="m_select">
					<font>搜索内容: <input type="text" name="dustbinMailKeyWord" placeholder="请输入关键字" value="${dustbinMailKeyWord }"> 搜索字段:</font>
					<select name="dustbinMailSearchField">
								<option selected="selected" value="m_theme" ${dustbinMailSearchField eq "m_theme" ? "selected" : ""}>主题</option>
								<option value="a.u_name" ${dustbinMailSearchField eq "m_receiveid" ? "selected" : ""}>收件人</option>
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
                <th>发件人</th>
                <th>主题</th>
                <th>发送时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="mail" items="${dustbinMailList }" varStatus="status">
            <tr>
                <td>${status.count + (pageInfo.currentPage - 1)*15 }</td>
                <td>${mail.r_name }</td>
                <td>${mail.s_name }</td>
                <td><a href="<c:url value="/mailInfo?m_id="/>${mail.m_id }">
						 	${mail.m_theme }
                </a></td>
                <td><fmt:formatDate value="${mail.m_sendtime }" type="both" pattern="YYYY-MM-dd HH:mm"/></td>
                 <td>
                	<a class="fa fa-remove" title="删除" onclick="deleteConfirm(${user.u_id },${mail.m_sendid },${mail.m_id},${pageInfo.currentPage})" ></a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <%@ include file="/page.jsp" %>
	</div>
</body>
</html>