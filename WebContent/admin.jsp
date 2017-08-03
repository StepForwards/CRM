<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="header">
	    <h1><a href="admin.jsp">智游客户关系管理系统</a></h1>
	    <div class="nav">
	    	<a target="" href="#">工作台</a>
            <a target="" href="#">报表</a>
            <a target="" href="#">客户信息</a>
            <a target="" href="#">员工信息</a>
            <a target="" href="#">公告信息</a>
            <a target="" href="#">发件箱</a>
	    </div>
	    
	    <div class="user">
	        <a href="#">${user.u_name }</a>
	        <a href="<c:url value="/exit" />">退出</a>
	    </div>
    </div>
    <div class="main">
	    <ul class="left-side">
	    	<li class="menu-title">
	    		<a href="#">
	    			<i class=" fa fa-users"></i>&nbsp;&nbsp;客户管理
	    		</a>
	    	</li>
	    	<li class="sub-menu">
			   	<ul>
		            <li>
		            	<a href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户信息
		            	</a>
		            </li>
		            <li>
		            	<a href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户分配
		            	</a>
		            </li>
		            <li>
		            	<a href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户关怀
		            	</a>
		            </li>
		            <li>
		            	<a target="" href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户分类
		            	</a>
		            </li>
		            <li>
		            	<a target="" href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户状态
		            	</a>
		            </li>
		            <li>
		            	<a target="" href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户来源
		            	</a>
		            </li>
		        </ul>
	        </li>
	        <li class="menu-title ">
	        	<a href="#">
	    			<i class=" fa fa-file-text"></i>&nbsp;&nbsp;内部信息
	    		</a>
	    	</li>
	        <li class="sub-menu">
		        <ul>
		        	<li>
		        		<a target="pageBox" href="http://www.baidu.com">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;通知公告
		            	</a>
		        	</li>
		            <li>
		            	<a target="" href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;员工信息
		            	</a>
		            </li>
		            <li>
		            	<a target="" href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;部门信息
		            	</a>
		            </li>
		        </ul>
	        </li>
	        <li class="menu-title">
	        	<a href="#">
	    			<i class=" fa fa-envelope"></i>&nbsp;&nbsp;站内邮件
	    		</a>
	        </li>
	        <li class="sub-menu">
		        <ul>
		            <li>
		            	<a target="pageBox" href="<c:url value="writeMail"/>">
		            		<i class=" fa fa-circle-thin" name="mail" ></i>&nbsp;&nbsp;写邮件
		            	</a>
		           	</li>
		            <li>
		            	<a target="pageBox" href="<c:url value="inboxMailList?m_receivestatus=1"/>">
		            		<i class=" fa fa-circle-thin" name="mail" ></i>&nbsp;&nbsp;收件箱
		            	</a>
		           	</li>
		            <li>
		            	<a target="pageBox" href="<c:url value="sendMailList?m_sendstatus=1"/>">
		            		<i class=" fa fa-circle-thin" name="mail" id="outbox" ></i>&nbsp;&nbsp;发件箱
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href="<c:url value="draftsMailList?m_sendstatus=2"/>">
		            		<i class=" fa fa-circle-thin" name="mail" ></i>&nbsp;&nbsp;草稿箱
		            	</a>
		            </li>
		             <li>
		            	<a target="pageBox" href="<c:url value="dustbinMailList?m_sendstatus=3"/>">
		            		<i class=" fa fa-circle-thin" name="mail" ></i>&nbsp;&nbsp;垃圾箱
		            	</a>
		            </li>
		        </ul>
	        </li>
	        <li class="menu-title active">
	        	<a href="#">
	    			<i class=" fa fa-sitemap"></i>&nbsp;&nbsp;管理员
	    		</a>
	        </li>
	        <li class="sub-menu">
		        <ul class="menu">
		        	<li>
		        		<a target="pageBox" href="<c:url value="noticeList"/>">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;公告管理
		            	</a>
		        	</li>
		            <li>
		            	<a target="pageBox" href="${pageContext.request.contextPath }/selectAllDepartment">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;部门管理
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href="${pageContext.request.contextPath }/selectAllRole">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;角色管理
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href="${pageContext.request.contextPath }/selectAllUser">
		            		<i class=" fa fa-circle"></i>&nbsp;&nbsp;用户管理
		            	</a>
		            </li>
		        </ul> 
	        </li>
	    </ul>
	    <div class="right-side">
	    		<iframe name="pageBox" src="${pageContext.request.contextPath }/selectAllUser"></iframe>
		    <div class="footer">
		    	智游教育 ©2017 河南智游臻龙教育科技有限公司
		    </div>
	    </div>    
    </div>
    <script src="lib/jquery/jquery.js"></script>
    <script src="js/admin.js"></script>
</body>
</html>