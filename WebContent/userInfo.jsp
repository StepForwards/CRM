<%@page import="com.forward.service.impl.UserServiceImpl"
		import="com.forward.service.UserService"
		import="com.forward.model.Department"
		import="com.forward.model.Role"
		import="java.util.List"
		%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户信息</title>
	<style type="text/css">
		body{
			background-color: #acacac;
			text-align: center;
		}
		div{
			width: 552px;
			margin: 100px auto;
		}
		td{
			background-color: white;
		}
	</style>
</head>
<body>

	<div>
		<h1 style="color: white">用户信息</h1>	
			<table style="margin: 0 auto;">
				<tr>
					<td>用户名</td>
					<td>${users.u_name }</td>
					<td>密码</td>
					<td>${users.u_pwd }</td>
				</tr>
				<tr>
					<td>部门</td>
					<td>${users.u_departmentid }</td>
					<td>角色</td>
					<td>${users.u_roleid }</td>
				</tr>
				
				<tr>
					<td>性别</td>
					<td>${users.u_sex}</td>
					<td>手机号</td>
					<td>${users.u_phone }</td>
				</tr>
				
				<tr>
					<td>地址</td>
					<td>${users.u_address }</td>
					<td>年龄</td>
					<td>${users.u_age }</td>
				</tr>
				
				<tr>
					<td>固定电话</td>
					<td>${users.u_telphone }</td>
					<td>身份证号</td>
					<td>${users.u_idcard }</td>
				</tr>
				
				<tr>
					<td>电子邮箱</td>
					<td>${users.u_mail }</td>
					<td>QQ号</td>
					<td>${users.u_qq }</td>
				</tr>
				
				<tr>
					<td>爱好</td>
					<td>${users.u_hobby }</td>
					<td>学历</td>
					<td>${users.u_edu }</td>
				</tr>
				
				<tr>
					<td>工资卡号</td>
					<td>${users.u_salarycard }</td>
					<td>民族</td>
					<td>${users.u_nation }</td>
				</tr>
				
				<tr>
					<td>婚姻</td>
					<td colspan="3">${users.u_marry}</td>
				</tr>
				
				<tr>
					<td>备注</td>
					<td colspan="3">${users.u_remark }</td>
				</tr>
			</table>
			<button type="button"><a href="javascript:history.go(-1)" style="text-decoration: none;">返回</a></button>
		</form>
	</div>
</body>
</html>