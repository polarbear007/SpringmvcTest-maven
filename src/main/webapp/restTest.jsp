<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>REST风格测试</h1>
	<a href="${pageContext.request.contextPath }/rest/test.action">Rest test</a><br>
	<h3>rest 四种请求类型</h3>
	<form action="${pageContext.request.contextPath }/rest/user.action" method="get">
		uid: <input type="text" name="uid" > <br>
		<input type="submit" value="get提交">
	</form>
	<form action="${pageContext.request.contextPath }/rest/user.action" method="post">
		uid: <input type="text" name="uid" > <br>
		username: <input type="text" name="username" > <br>
		password: <input type="password" name="password" > <br>
		<input type="submit" value="post提交">
	</form>
	<form action="${pageContext.request.contextPath }/rest/user.action" method="post">
		<input type="hidden" name="_method" value="DELETE">
		uid: <input type="text" name="uid" > <br>
		<input type="submit" value="delete提交">
	</form>
	<form action="${pageContext.request.contextPath }/rest/user.action" method="post">
		<input type="hidden" name="_method" value="PUT">
		uid: <input type="text" name="uid" > <br>
		username : <input type="text" name="username" > <br>
		password : <input type="password" name="password" > <br>
		<input type="submit" value="put提交">
	</form>
	<hr>
	
	<h2>演示如何从 url 路径上面获取参数</h2>
	<a href="${pageContext.request.contextPath }/rest/pathvariable/user/10.action">Rest findUser2</a><br>
</body>
</html>