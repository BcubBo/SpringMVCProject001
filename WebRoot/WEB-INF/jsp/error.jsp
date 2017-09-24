<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="sfm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function erroJump(){

		var jump = setTimeout(function(){window.location.href="${pageContext.getRequest().getContextPath()}"},1000);
	}
	window.onload=erroJump();
</script>
<title>错误！</title>
</head>
<body style="background-color:grey">
<h3 style="color:gold">${e.message }</h3>
<h3>将跳转到登陆界面</h3>
</body>
</html>