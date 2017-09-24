<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="sfm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/statics/css/main.css" rel="stylesheet"/>
<title>add页面</title>
</head>
<body>
<!-- 不指定action，那么请求提交到add -->
<table>
<sfm:form modelAttribute="user" method="post" action="addsave" enctype="multipart/form-data">
	
	<tr><td>ID:</td><td><sfm:input path="id" cssStyle="background-color:lightgrey"/></td></tr>
	<tr><td>userName:</td><td><sfm:input path="userName" cssStyle="background-color:lightgrey"/></td><td><sfm:errors path="userName"/></td></tr>
	<tr><td>password:</td><td><sfm:input path="password" cssStyle="background-color:lightgrey"/></td><td><sfm:errors path="password"/></td></tr>
	<tr><td>email:</td><td><sfm:input path="email" cssStyle="background-color:lightgrey"/></td><td><sfm:errors path="email"/></td></tr>
	<tr><td>attach:</td><td><input type="file" name="attachs" /></td></tr>
	<tr><td>attach:</td><td><input type="file" name="attachs" /></td></tr>
	<tr><td>attach:</td><td><input type="file" name="attachs" /></td></tr>
	<tr><td>attach:</td><td><input type="file" name="attachs" /></td></tr>
	<tr><td><input type="submit" value="上传"/></td></tr>
	
	
</sfm:form>
</table>
</body>
</html>