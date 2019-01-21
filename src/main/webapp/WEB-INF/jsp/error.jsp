<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>错误页面</h2>
<h2>使用spring提供的 form 标签来显示错误信息</h2>
<form:form modelAttribute="teacher"> 
	<form:errors path="*"></form:errors>
</form:form>
<hr>
<h2>使用jstl 标签来显示错误信息1</h2>
<c:forEach items="${errors }" var="error">
	${error.field } : ${error.defaultMessage }<br>
</c:forEach>
<hr>
<h2>使用jstl 标签来显示错误信息2</h2>
<c:forEach items="${errors }" var="error">
	${error.field } : <fmt:message key="${error.codes[0] }"/><br>
</c:forEach>

<h2>使用jstl 标签来显示错误信息3</h2>
<%-- 
	【注意】 这次我们是想要通过显示通用的  类型转换失败 信息， 因为使用的 code 不一样，所以这里需要多一层判断
  --%>
<c:forEach items="${errors }" var="error">
	<c:choose>
		<c:when test="${error.code != 'typeMismatch' }">
			${error.field } : <fmt:message key="${error.codes[0] }"/><br>
		</c:when>
		<c:otherwise>
			${error.field } : <fmt:message key="${error.code }"/><br>
		</c:otherwise>
	</c:choose>
</c:forEach>
</body>
</html>