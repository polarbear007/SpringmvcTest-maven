<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/modelAttribute/test1.action" method="post">
		uid: <input name="uid" ><br>
		username: <input name="username"> <br>
		password: <input name="password"> <br>
		<input type="submit" value="提交 ">
	</form> 
	<hr>
	<form action="${pageContext.request.contextPath }/modelAttribute/test2.action" method="post">
		<!-- <input type="hidden" name="_method" value="put"> -->
		uid: <input name="uid" ><br>
		username: <input name="username"> <br>
		password: <input name="password"> <br> 
		<input type="submit" value="提交 ">
	</form> 
	
	<a href="${pageContext.request.contextPath }/modelAttribute/test2.action?username=Jack">测试</a>
</body>
</html>