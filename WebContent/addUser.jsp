<%@page import="com.forward.service.impl.UserServiceImpl"
		import="com.forward.service.UserService"
		import="com.forward.model.Department"
		import="com.forward.model.Role"
		import="java.util.List"
		%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加用户信息</title>
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
		<h1 style="color: white">添加用户</h1>
		${state }<%session.removeAttribute("state"); %>
		<form action="${pageContext.request.contextPath }/addUser" method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td><input name="u_name" type="text" placeholder="请填写用户名"></td>
					<td>密码</td>
					<td><input name="u_pwd" type="password" placeholder="密码"></td>
				</tr>
				
				<tr>
					<td>部门</td>
					<td>
						<select name="u_departmentid">
						<%
							UserService us = new UserServiceImpl();
						    List<Department> list = us.selectDepartment();
						    for(Department department : list){
						    	out.print("<option value=\""+department.getD_id()+"\">"+department.getD_name()+"</option>");
						    }
						%>
						</select>
					</td>
					<td>角色</td>
					<td>
						<select name="u_roleid">
						<%
						    List<Role> lists = us.selectRole();
						    for(Role role : lists){
						    	out.print("<option value=\""+role.getR_id()+"\">"+role.getR_name()+"</option>");
						    }
						%>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>性别</td>
					<td>男<input name="u_sex" type="radio" value="男" checked="checked">女<input name="sex" type="radio" value="女"></td>
					<td>手机号</td>
					<td><input name="u_phone" type="text" placeholder="请输入手机号"></td>
				</tr>
				
				<tr>
					<td>地址</td>
					<td><input name="u_address" type="text" placeholder="请填写地址"></td>
					<td>年龄</td>
					<td><input name="u_age" type="text" placeholder="请填写年龄"></td>
				</tr>
				
				<tr>
					<td>固定电话</td>
					<td><input name="u_telphone" type="text" placeholder="请填写固定电话"></td>
					<td>身份证号</td>
					<td><input name="u_idcard" type="text" placeholder="请填写身份证号"></td>
				</tr>
				
				<tr>
					<td>电子邮箱</td>
					<td><input name="u_mail" type="text" placeholder="请填写电子邮箱"></td>
					<td>QQ号</td>
					<td><input name="u_qq" type="text" placeholder="请填写QQ号"></td>
				</tr>
				
				<tr>
					<td>爱好</td>
					<td><input name="u_hobby" type="text" placeholder="请填写爱好"></td>
					<td>学历</td>
					<td>		
						<select name="u_edu">
							<option>幼儿园</option>
							<option>小学</option>
							<option>初中</option>
							<option>高中</option>
							<option>专科</option>
							<option>本科</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>工资卡号</td>
					<td><input name="u_salarycard" type="text" placeholder="请填写工资卡号"></td>
					<td>民族</td>
					<td><input name="u_nation" type="text" placeholder="请填写民族"></td>
				</tr>
				
				<tr>
					<td>婚姻状况</td>
					<td colspan="3">
						<select name="u_marry">
							<option>离异</option>
							<option>已婚</option>
							<option>未婚</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>备注</td>
					<td colspan="3"><textarea rows="5" cols="65" name="u_remark" resize="none" style="resize: none"></textarea></td>
				</tr>
			</table>
			<input type="submit"><button type="button"><a href="javascript:history.go(-1)" style="text-decoration: none;">返回</a></button>
		</form>
	</div>
</body>
</html>