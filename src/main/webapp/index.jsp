<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/hello.action">hello world</a><br>
	<a href="${pageContext.request.contextPath }/hello2.action">hello world2</a><br>
	<a href="${pageContext.request.contextPath }/hello3.action">hello world3</a><br>
	<hr>
	<h4>只能使用 post 方式请求此方法</h4>
	<a href="${pageContext.request.contextPath }/hello4.action">hello world4</a>
	<form action="${pageContext.request.contextPath }/hello4.action" method="post">
		<input type="submit" value="hello4 --> post提交 ">
	</form>
	<hr>
	<h4>请求必须带有abc 参数</h4>
	<a href="${pageContext.request.contextPath }/hello5.action">hello world5, 没有参数</a><br>
	<a href="${pageContext.request.contextPath }/hello5.action?abc=123">hello world5, 带有参数</a><br>
	<hr>
	<h4>请求头里面必须带有  content-type=application/x-www-form-urlencoded（post提交默认）</h4>
	<a href="${pageContext.request.contextPath }/hello6.action">hello world6</a><br>
	<form action="${pageContext.request.contextPath }/hello6.action" method="post">
		<input type="submit" value="hello6 --> post提交 ">
	</form>
	<hr>
	<hr>
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
	<hr>
	<hr>
	<h1>演示一下 mvc:view-controller 标签能不能让我们直接访问 /web-inf 目录下的资源</h1>
	<a href="${pageContext.request.contextPath }/toResult">访问/web-inf 目录下的 result.jsp</a>
	<hr>
	<hr>
	
	<h2>跳转到 Employees 的查询页面</h2>
	<a href="${pageContext.request.contextPath }/employees/findAll">Employees 查询页面</a>
</body>
</html>