<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表展示</title>
</head>
<body style="background-color:grey">
<h1><strong style="color:greenyellow">===用户列表查询===</strong></h1>
<h2><strong style="color:greenyellow"><c:forEach items="${userList}" var="userObjectMap">
	id:${userObjectMap.value.id }<br/>
	<a href="view/${userObjectMap.value.id }" style="text-decoration: none;color:greenyellow">username:${userObjectMap.value.userName }</a><br/>
	password:${userObjectMap.value.password }<br/>
	email:${userObjectMap.value.email }<a href="${userObjectMap.value.id }/update" style="text-decoration: none">修改</a>
	<a href="${userObjectMap.value.id }/delete" style="text-decoration: none">删除</a>
	<br/>
	<hr/>
<%-- 	id:${userObjectMap.value.id }
	username:${userObjectMap.userName }
	password:${userObjectMap.password }
	email:${userObjectMap.email }<br/> --%>	
		
</c:forEach></strong></h2>
<a href="add">添加</a><br/>

</body>
</html>