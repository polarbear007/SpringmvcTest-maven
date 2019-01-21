<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>测试一下能不能把表单中的字符串转成 Date 类型</h2>
	<form action="${pageContext.request.contextPath }/initBinder2/test" method="post">
		empNo:<input type="text" name="empNo"><br>
		birthDate:<input type="text" name="birthDate"><br>
		firstName:<input type="text" name="firstName"><br>
		lastName:<input type="text" name="lastName"><br>
		gender:<input type="text" name="gender"><br>
		hireDate:<input type="text" name="hireDate"><br>
		<input type="submit" value="submit">
	</form>
	
	<hr>
	<h2>测试一下如果表单中缺少必要的empNo字段，会怎么样</h2>
	<form action="${pageContext.request.contextPath }/initBinder2/test" method="post">
		birthDate:<input type="text" name="birthDate"><br>
		firstName:<input type="text" name="firstName"><br>
		lastName:<input type="text" name="lastName"><br>
		gender:<input type="text" name="gender"><br>
		hireDate:<input type="text" name="hireDate"><br>
		<input type="submit" value="submit">
	</form>
	
	<hr>
	<h2>测试一下DataBinder 能不能把Date 对象转成我们想要的那种日期格式字符串（不能）</h2>
	<form action="${pageContext.request.contextPath }/initBinder2/test2" method="post">
		empNo:<input type="text" name="empNo"><br>
		birthDate:<input type="text" name="birthDate"><br>
		firstName:<input type="text" name="firstName"><br>
		lastName:<input type="text" name="lastName"><br>
		gender:<input type="text" name="gender"><br>
		hireDate:<input type="text" name="hireDate"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>