<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sfm" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/statics/css/main.css" rel="stylesheet"/>
<title>登陆</title>
</head>
<body style="background-color:grey">
	<form action="user/login" method="post">
	<table>
		<tr>
			<td>userName:</td>
			<td><input type="text" name="userName" style="background-color: lightgrey;border-color: gold;"/><br/></td>
			
		</tr>
		<tr>
			<td>password:</td>
			<td><input type="text" name="password" style="background-color: lightgrey;border-color: gold;"/><br/></td>
		</tr>
		<tr align="right">
			<td colspan="4"><input type="submit" value="登陆" style="background-color: lightgrey;border-color: gold;"/>
				<input type="button" value="陆登" style="background-color: lightgrey;border-color: gold;"/>
				<input type="button" value="陆登" style="background-color: lightgrey;border-color: gold;"/>
				<input type="button" value="陆登" style="background-color: lightgrey;border-color: gold;"/>
				<input type="button" value="陆登" style="background-color: lightgrey;border-color: gold;"/>
			</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
		
		
		
	</form>
</body>
</html>