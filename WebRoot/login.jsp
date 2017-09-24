<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sfm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body style="background-color:grey">
	<form action="user/login" method="post">
		userName:<input type="text" name="userName"/><br/>
		password:<input type="text" name="password"/><br/>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>