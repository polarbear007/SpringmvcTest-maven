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
	<form action="${pageContext.request.contextPath }/employees/updateEmployees" method="post">
		<table border="1" style="width: 800px; " >
			<caption><h2>修改员工信息</h2></caption>
			<tr>
				<td>编号</td>
				<td><input type="text" name="empNo" value="${employees.empNo }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthDate" value="<fmt:formatDate value="${employees.birthDate }" pattern="yyyy-MM-dd"/>" ></td>
			</tr>
			<tr>
				<td>名</td>
				<td><input type="text" name="firstName" value="${employees.firstName }"></td>
			</tr>
			<tr>
				<td>姓</td>
				<td><input type="text" name="lastName" value="${employees.lastName }"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<c:choose>
						<c:when test="${employees.gender == 'F' }">
							<input type="radio" name="gender" value="F" checked="checked"> 女  <input type="radio" name="gender" value="M"> 男
						</c:when>
						<c:otherwise>
							<input type="radio" name="gender" value="F" > 女  <input type="radio" name="gender" value="M" checked="checked"> 男
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>入职日期</td>
				<td><input type="text" name="hireDate" value="<fmt:formatDate value="${employees.hireDate }" pattern="yyyy-MM-dd" />"></td>
			</tr>
		</table>
		<input type="submit" value="修改">
	</form>
</body>
</html>