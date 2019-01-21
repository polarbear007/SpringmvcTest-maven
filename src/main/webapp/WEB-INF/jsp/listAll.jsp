<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 800px; " >
		<caption><h2>员工列表</h2></caption>
		<thead>
			<tr>
				<td>
				<input type="checkbox">
				全选
				</td>
				<td>编号</td>
				<td>生日</td>
				<td>名</td>
				<td>姓</td>
				<td>性别</td>
				<td>入职日期</td>
				<td>修改</td>
				<td>删除</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page }" var="employees">
				<tr>
					<td><input type="checkbox"></td>
					<td>${employees.empNo }</td>
					<td><fmt:formatDate value="${employees.birthDate }" pattern="yyyy-MM-dd" /></td>
					<td>${employees.firstName }</td>
					<td>${employees.lastName }</td>
					<td>${employees.gender }</td>
					<td><fmt:formatDate value="${employees.hireDate }" pattern="yyyy-MM-dd" /></td>
					<td><a href="${pageContext.request.contextPath }/employees/updateEmployeesPage.action?empNo=${employees.empNo }">修改</a></td>
					<td><a href="${pageContext.request.contextPath }/employees/deleteEmployeesById.action?empNo=${employees.empNo }">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath }/employees/addEmployeesPage">添加员工</a>
</body>
</html>