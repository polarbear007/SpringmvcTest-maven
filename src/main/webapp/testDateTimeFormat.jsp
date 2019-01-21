<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>测试一下@DateTimeFormat 能不能把字符串数据转换成日期数据</h2>
	<form action="${pageContext.request.contextPath }/student/test" method="post">
		stuId:<input type="text" name="stuId"><br>
		sname:<input type="text" name="sname"><br>
		birthDate:<input type="text" name="birthDate"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>