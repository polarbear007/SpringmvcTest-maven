<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/employees/addEmployees" method="post">
		<input type="hidden" name="_method" value="put">
		<table border="1" style="width: 800px; " >
			<caption><h2>添加员工信息</h2></caption>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthDate" ></td>
			</tr>
			<tr>
				<td>名</td>
				<td><input type="text" name="firstName" ></td>
			</tr>
			<tr>
				<td>姓</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="gender" value="F" > 女  <input type="radio" name="gender" value="M"> 男
				</td>
			</tr>
			<tr>
				<td>入职日期</td>
				<td><input type="text" name="hireDate" ></td>
			</tr>
		</table>
		<input type="submit" value="添加">
	</form>
</body>
</html>