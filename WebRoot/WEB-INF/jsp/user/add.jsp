<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="sfm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add页面</title>
</head>
<body>
<!-- 不指定action，那么请求提交到add -->
<sfm:form modelAttribute="user" method="post" action="addsave">
	ID:<sfm:input path="id"/><br/>
	userName:<sfm:input path="userName"/><sfm:errors path="userName"/><br/>
	password:<sfm:input path="password"/><sfm:errors path="password"/><br/>
	email:<sfm:input path="email"/><br/><sfm:errors path="email"/>
	<input type="submit" value="上传"/>
</sfm:form>
</body>
</html>