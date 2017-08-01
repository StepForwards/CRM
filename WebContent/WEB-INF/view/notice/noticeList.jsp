<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告管理 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">

<script type="text/javascript">
		function deleteConfirm(n_id,page) {
			var c = confirm("确定删除吗?");
			if(c == true){
				document.location="deleteNotice?id="+n_id+"&page="+page;
			}
		}
</script>

</head>
<body>
	<div class="box">
		<h3>公告管理</h3>
		<div class="actions">
			<div>
				<form action="${pageContext.request.contextPath }/noticeList">
					<font>搜索内容: <input type="text" name="noticeKeyWord" placeholder="请输入关键字" value="${noticeKeyWord }"> 搜索字段:</font>
					<select name="noticeSearchField">
								<option value="n_theme" ${noticeSearchField eq "n_theme" ? "selected" : ""}>主题</option>
								<option value="n_content" ${noticeSearchField eq "n_content" ? "selected" : ""}>内容</option>
					</select>
					<input type="submit" value="搜索" class="btn btn-primary">
				</form>
			</div>
			<div>
				<a class="btn btn-primary" href="<c:url value="/addNotice"/>">发布公告</a>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>公告人</th>
                <th>公告主题</th>
                <th>通知范围</th>
                <th>公告内容</th>
                <th>公告时间</th>
                <th>截止时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="notice" items="${noticeList }" varStatus="status">
            <tr>
                <td>${status.count + (pageInfo.currentPage - 1)*15 }</td>
                <td>${notice.u_name }</td>
                <td>${notice.n_theme }</td>
                <td>${notice.n_departmentid == 0 ? "全部" : notice.d_name }</td>
                <td><a href="<c:url value="/noticeInfo?n_id="/>${notice.n_id }">
                	<c:choose>
               			 <c:when test="${fn:length(notice.n_content) > 20 }">
	               			 ${fn:substring(notice.n_content,0,20) }......
               			 </c:when>
						 <c:otherwise>
						 	${notice.n_content }
						 </c:otherwise>	                	
                	</c:choose>
               			 
                </a></td>
                <td><fmt:formatDate value="${notice.n_begintime }" type="both" pattern="YYYY-MM-dd HH:mm"/></td>
                <td><fmt:formatDate value="${notice.n_endtime }" type="both" pattern="YYYY-MM-dd HH:mm"/></td>
                 <td>
                	<a class="fa fa-pencil" title="编辑" href="<c:url value="/updateNotice?id="/>${notice.n_id}"></a>
                	&nbsp;&nbsp;
                	<a class="fa fa-remove" title="删除" onclick="deleteConfirm(${notice.n_id},${pageInfo.currentPage})" ></a>
                	<%-- href="<c:url value="/deleteNotice?id="/>${notice.n_id}&page=${pageInfo.currentPage}" --%>
                </td>
            </tr>
            </c:forEach>
        </table>
        <%@ include file="/page.jsp" %>
	</div>
</body>
</html>