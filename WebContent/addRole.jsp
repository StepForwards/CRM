<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加角色</title>
	<style>
		body{
			text-align: center;
			background-color: #acacac;
		}
		div{
			margin: 100px auto;
		}
	</style>
</head>
<body>
<div style="width: 1000px; height: 800px; background-color: white; ">
	<p style="font-size: 24px;">添加角色</p>
	<form action="${pageContext.request.contextPath }/addRole">
		<table>
			<tr>
				<td>角色名称</td>
				<td>				
					<input type="text" placeholder="请填写角色名称" name="r_name">
				</td>
			</tr>
				<td>角色描述</td>
				<td>
					<textarea rows="10" cols="10" name="r_desc" placeholder="请填写角色描述"></textarea>	
				</td>
		</table>
		<input type="submit" style="background-color: #3388ff">${stateDepartment }<%session.removeAttribute("stateDepartment"); %>
		<button type="button"><a href="javascript:history.go(-1)" style="text-decoration: none;">返回</a></button>		
	</form>
</div>	
</body>
</html>