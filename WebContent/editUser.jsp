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
	<title>更新用户信息</title>
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

	<div  style="width: 1000px; height: 800px; background-color: white; ">
		<h1>更新用户</h1>
		<form action="${pageContext.request.contextPath }/updateKindINfo" method="post">
		<input type="hidden" name="kind" value="user">	
			<table  style="margin: 0 auto; background-color: gray;">
				<tr>
					<td>用户名</td>
					<td><input type="hidden" name="u_id" value="${users.u_id }" >
					<input name="u_name" type="text" placeholder="请填写用户名" value="${users.u_name }" ></td>
					<td>密码</td>
					<td><input name="u_pwd" type="password" placeholder="密码" value="${users.u_pwd }" ></td>
				</tr>
				
				<tr>
					<td>部门</td>
					<td>
						<select name="u_departmentid">
							<c:forEach items="${deList }" var="deList">
								<c:choose>
									<c:when test="${deList.d_id == users.u_departmentid }">
										<option value="${deList.d_id }" selected="selected">${deList.d_name }</option>
									</c:when>
									<c:otherwise>
										<option value="${deList.d_id }">${deList.d_name }</option>									
									</c:otherwise>											
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<td>角色</td>
					<td>
						<select name="u_roleid">
							<c:forEach items="${roList }" var="roList">
								<c:choose>
									<c:when test="${roList.r_id == users.u_roleid }">
										<option value="${roList.r_id }" selected="selected">${roList.r_name }</option>									
									</c:when>
									<c:otherwise>
										<option value="${roList.r_id }">${roList.r_name }</option>																	
									</c:otherwise>
								</c:choose>								
								
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>性别</td>
					<td>
					
					<c:choose>
						<c:when test="${users.u_sex == '男' }">
							男<input name="u_sex" type="radio" value="男" checked="checked">				
							女<input name="u_sex" type="radio" value="女" >						
						</c:when>
					
						<c:otherwise>
							男<input name="u_sex" type="radio" value="男" >				
							女<input name="u_sex" type="radio" value="女" checked="checked">
						</c:otherwise>
					</c:choose>
						
					
					
					
					</td>
					<td>手机号</td>
					<td><input name="u_phone" type="text" placeholder="请输入手机号" value="${users.u_phone }"></td>
				</tr>
				
				<tr>
					<td>地址</td>
					<td><input name="u_address" type="text" placeholder="请填写地址" value="${users.u_address }"></td>
					<td>年龄</td>
					<td><input name="u_age" type="text" placeholder="请填写年龄" value="${users.u_age }"></td>
				</tr>
				
				<tr>
					<td>固定电话</td>
					<td><input name="u_telphone" type="text" placeholder="请填写固定电话" value="${users.u_telphone }"></td>
					<td>身份证号</td>
					<td><input name="u_idcard" type="text" placeholder="请填写身份证号" value="${users.u_idcard }"></td>
				</tr>
				
				<tr>
					<td>电子邮箱</td>
					<td><input name="u_mail" type="text" placeholder="请填写电子邮箱" value="${users.u_mail }"></td>
					<td>QQ号</td>
					<td><input name="u_qq" type="text" placeholder="请填写QQ号" value="${users.u_qq }"></td>
				</tr>
				
				<tr>
					<td>爱好</td>
					<td><input name="u_hobby" type="text" placeholder="请填写爱好" value="${users.u_hobby }"></td>
					<td>学历</td>
					<td>		
						<select name="u_edu">
							<c:choose>
								<c:when test="${users.u_edu == '幼儿园' }">
									<option selected="selected">幼儿园</option>
									<option>小学</option>
									<option>初中</option>
									<option>高中</option>
									<option>复习生</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
									<option>博士后</option>
									<option>院士</option>
								</c:when>
								<c:when test="${users.u_edu == '小学' }">
									<option>幼儿园</option>
									<option selected="selected">小学</option>
									<option>初中</option>
									<option>高中</option>
									<option>复习生</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
									<option>博士后</option>
									<option>院士</option>
								</c:when>
								<c:when test="${users.u_edu == '初中' }">
									<option>幼儿园</option>
									<option>小学</option>
									<option selected="selected">初中</option>
									<option>高中</option>
									<option>复习生</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
									<option>博士后</option>
									<option>院士</option>
								</c:when>
								<c:when test="${users.u_edu == '高中' }">
									<option>幼儿园</option>
									<option>小学</option>
									<option>初中</option>
									<option selected="selected">高中</option>
									<option>复习生</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
									<option>博士后</option>
									<option>院士</option>
								</c:when>
								<c:when test="${users.u_edu == '复习生' }">
									<option>幼儿园</option>
									<option>小学</option>
									<option>初中</option>
									<option>高中</option>
									<option selected="selected">复习生</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
									<option>博士后</option>
									<option>院士</option>
								</c:when>
								<c:when test="${users.u_edu == '大学' }">
									<option>幼儿园</option>
									<option>小学</option>
									<option>初中</option>
									<option>高中</option>
									<option>复习生</option>
									<option selected="selected">大学</option>
									<option>硕士</option>
									<option>博士</option>
									<option>博士后</option>
									<option>院士</option>
								</c:when>
								<c:when test="${users.u_edu == '硕士' }">
									<option>幼儿园</option>
									<option>小学</option>
									<option>初中</option>
									<option>高中</option>
									<option>复习生</option>
									<option>大学</option>
									<option selected="selected">硕士</option>
									<option>博士</option>
									<option>博士后</option>
									<option>院士</option>
								</c:when>
								<c:when test="${users.u_edu == '博士' }">
									<option>幼儿园</option>
									<option>小学</option>
									<option>初中</option>
									<option >高中</option>
									<option>复习生</option>
									<option>大学</option>
									<option>硕士</option>
									<option selected="selected">博士</option>
									<option>博士后</option>
									<option>院士</option>
								</c:when>
								<c:when test="${users.u_edu == '博士后' }">
									<option>幼儿园</option>
									<option>小学</option>
									<option>初中</option>
									<option >高中</option>
									<option>复习生</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
									<option selected="selected">博士后</option>
									<option>院士</option>		
								</c:when>
								<c:otherwise>
									<option>幼儿园</option>
									<option>小学</option>
									<option>初中</option>
									<option>高中</option>
									<option>复习生</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
									<option>博士后</option>
									<option selected="selected">院士</option>			
								</c:otherwise>
							</c:choose>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>工资卡号</td>
					<td><input name="u_salarycard" type="text" placeholder="请填写工资卡号" value="${users.u_salarycard }"></td>
					<td>民族</td>
					<td><input name="u_nation" type="text" placeholder="请填写民族" value="${users.u_nation }"></td>
				</tr>
				
				<tr>
					<td>婚姻状况</td>
					<td colspan="3">
						<select name="u_marry">
							<c:choose>
								<c:when test="${users.u_marry == '离异' }">
									<option selected="selected">离异</option>
									<option>已婚</option>
									<option>未婚</option>			
								</c:when>
								<c:when test="${users.u_marry == '已婚' }">
									<option>离异</option>
									<option selected="selected">已婚</option>
									<option>未婚</option>			
								</c:when>
								<c:otherwise>
									<option>离异</option>
									<option>已婚</option>
									<option selected="selected">未婚</option>			
								</c:otherwise>
							</c:choose>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>备注</td>
					<td colspan="3"><textarea rows="5" cols="65" name="u_remark" resize="none" style="resize: none">${users.u_remark }</textarea></td>
				</tr>
			</table>
			<input type="submit"><button type="button"><a href="javascript:history.go(-1)" style="text-decoration: none;">返回</a></button>
		</form>
	</div>
</body>
</html>