<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/i18n/testI18nPage?lang=zh_CN">中文</a> | <a href="${pageContext.request.contextPath }/i18n/testI18nPage?lang=en_US">英语</a>
	
	<hr>
	<form action="${pageContext.request.contextPath }/i18n/login" method="post">
		<spring:message code="username" /> : <input type="text" name="username"><br>
		<spring:message code="password" /> : <input type="password" name="password"><br>
		<input type="submit" value="<spring:message code="login" />">
	</form>
</body>
</html>