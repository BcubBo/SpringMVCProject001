<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sfm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>udpate页面</title>
</head>
<body style="background-color:grey">
<h2><strong style="color:greenyellow">
	<sfm:form modelAttribute="user" method="post">
	 ID:${id}<br/>
	 username:${userName }<sfm:input path="userName"/><sfm:errors path="userName"/><br/>
	 password:${password }<sfm:input path="password"/><sfm:errors path="password"/><br/>
	 email:${email }<sfm:input path="email"/><sfm:errors path="email"/><br/>
	 <input type="submit" value="上传"/>
	</sfm:form>


</strong></h2>

</body>
</html>