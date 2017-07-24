<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加部门</title>
</head>
<body>
	<p style="font-size: 24px;">用户列表</p>
	<form action="${pageContext.request.contextPath }/addDepartment">
		<table>
			<tr>
				<td>部门名称</td>
				<td>				
					<input type="text" placeholder="填写部门名称" name="d_name">
				</td>
			</tr>
				<td>部门描述</td>
				<td>
					<textarea rows="10" cols="10" name="d_desc"></textarea>	
				</td>
		</table>
		<input type="submit" style="background-color: #3388ff">${stateDepartment }<%session.removeAttribute("stateDepartment"); %>
		<button type="button"><a href="javascript:history.go(-1)" style="text-decoration: none;">返回</a></button>		
	</form>
	
</body>
</html>