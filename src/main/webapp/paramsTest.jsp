<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>普通的表单参数传递, 表单的参数名与handler 方法里面的参数名一致，可以自动封装方法参数</h2>
	<form action="${pageContext.request.contextPath }/getInteger.action" method="post">
		<input type="text" name="paramId">
		<input type="submit">
	</form>
	<hr>
	
	<h2>普通的表单参数传递, 表单的参数名与handler 方法里面的参数名不一致，或者没有参数，则方法里的参数值为 null</h2>
	<form action="${pageContext.request.contextPath }/getInteger.action" method="post">
		<input type="text" name="abc">
		<input type="submit">
	</form>
	<hr>
	
	<h2>添加@RequestParam 注解，指定参数的名字;   则表单的参数名可以与方法里面的参数名不一致</h2>
	<form action="${pageContext.request.contextPath }/getInteger2.action" method="post">
		<input type="text" name="abc">
		<input type="submit">
	</form>
	<hr>
	
	<h2>添加@RequestParam 注解以后，如果我们没有传递该参数，会报错。 这是因为 required 属性默认为 true</h2>
	<a href="${pageContext.request.contextPath }/getInteger2.action">测试@RequestParam 注解required属性</a>
	<hr>
	
	<h2>添加@RequestParam 注解以后，我们可以给指定的参数指定一个默认值，如果我们没有传递该参数，则使用默认值</h2>
	<a href="${pageContext.request.contextPath }/getInteger3.action">测试@RequestParam 注解defaultValue属性</a>
	<hr>
	
	
	
</body>
</html>