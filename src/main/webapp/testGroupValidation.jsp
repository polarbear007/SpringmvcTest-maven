<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>添加客户</h2>
	<form action="${pageContext.request.contextPath }/customer/addCustomer.action" method="post">
		cid: <input type="text" name="cid"><br>
		cname: <input type="text" name="cname"><br>
		phone: <input type="text" name="phone"><br>
		nationality: <input type="text" name="address.nationality"><br>
		province: <input type="text" name="address.province"><br>
		city: <input type="text" name="address.city"><br>
		<input type="submit" value="submit">
	</form>
	<hr>
	
	<h2>修改客户</h2>
	<form action="${pageContext.request.contextPath }/customer/updateCustomer.action" method="post">
		cid: <input type="text" name="cid"><br>
		cname: <input type="text" name="cname"><br>
		phone: <input type="text" name="phone"><br>
		nationality: <input type="text" name="address.nationality"><br>
		province: <input type="text" name="address.province"><br>
		city: <input type="text" name="address.city"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>