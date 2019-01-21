<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>测试一下能不能校验Teacher 类的参数</h2>
	<form action="${pageContext.request.contextPath }/validation/test" method="post">
		 tid: <input type="text" name="tid"><br>
		 tname: <input type="text" name="tname"><br>
		 gender: <input type="text" name="gender"><br>
		 salary: <input type="text" name="salary"><br>
		 birthDate: <input type="text" name="birthDate"><br>
		 <input type="submit" value="submit">
	</form>
	<hr>
	<h2>测试一下能不能直接校验一个简单类型的参数</h2>
	<a href="${pageContext.request.contextPath }/validation/test2?score=101">测试成绩参数 score 是否满足要求</a>
	<hr>
	<h2>测试一下能不能显示validationMessage.properties 文件里面配置的校验信息</h2>
	<form action="${pageContext.request.contextPath }/validation/test3" method="post">
		 tid: <input type="text" name="tid"><br>
		 tname: <input type="text" name="tname"><br>
		 gender: <input type="text" name="gender"><br>
		 salary: <input type="text" name="salary"><br>
		 birthDate: <input type="text" name="birthDate"><br>
		 <input type="submit" value="submit">
	</form>
	
</body>
</html>