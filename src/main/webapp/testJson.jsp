<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#test1").click(function(){
			var url = "${pageContext.request.contextPath}/json/test.action";
			var data = {"uid":1, "username":"eric", "password":"123456" };
			// 其实$.post 和  $.get 本身就相当于在发送一个普通的表单，只不过是使用异步提交，不会发生页面跳转而已。
			//  @RequestBody 标注的参数无法解析表单数据
			$.post(
					url, 
					data, 
					function(data){
						alert(data);
					},
					"text"
				);
			return false;
		});
		
		$("#test3").click(function () {
			$.ajax({
				async : true,
				type : "post",
				url : "${pageContext.request.contextPath}/json/test.action",
				data : JSON.stringify({"uid":1, "username":"eric", "password":"123456" }),
				contentType : "application/json;charset=utf-8" ,
				success : function(data){
					alert(data);
				},
				error : function(){
					alert("请求失败");
				},
				dataType : "text"
			})
		});
		
		// 看一下 HttpEntity 能不能接收 json 格式的数据
		$("#test4").click(function () {
			$.ajax({
				async : true,
				type : "post",
				url : "${pageContext.request.contextPath}/json/test2.action",
				data : JSON.stringify({"uid":1, "username":"eric", "password":"123456" }),
				contentType : "application/json;charset=utf-8" ,
				success : function(data){
					alert(data);
				},
				error : function(){
					alert("请求失败");
				},
				dataType : "text"
			})
		});
		
		// 异步请求，看一下HttpEntity 作为返回值能不能把 user 对象转换成 json 格式数据并返回
		$("#test5").click(function () {
			$.post(
				"${pageContext.request.contextPath}/json/test4.action",
				null,
				function(data){
					console.log(data.uid);
					console.log(data.username);
					console.log(data.password)
				},
				"json"
			);
			return false;
		});
		
		// 看一下HttpEntity 作为入参可以携带哪些请求头信息
		$("#test6").click(function () {
			$.ajax({
				async : true,
				type : "post",
				url : "${pageContext.request.contextPath}/json/test5.action",
				data : JSON.stringify({"uid":1, "username":"eric", "password":"123456" }),
				contentType : "application/json;charset=utf-8" ,
				success : function(data){
					console.log(data);
				},
				error : function(){
					alert("请求失败");
				},
				dataType : "text"
			})
			return false;
		});
		
		// 看一下HttpEntity 作为返回值，可以设置什么请求头信息
		$("#test7").click(function () {
			$.ajax({
				async : true,
				type : "post",
				url : "${pageContext.request.contextPath}/json/test6.action",
				data : JSON.stringify({"uid":1, "username":"eric", "password":"123456" }),
				contentType : "application/json;charset=utf-8" ,
				success : function(data){
					alert(data);
				},
				error : function(){
					alert("请求失败");
				},
				dataType : "text"
			})
			return false;
		});
	})
</script>
</head>
<body>
	<h2>直接使用$.post  发送数据，@requestBody 无法接收参数</h2>
	<a href="" id="test1">$.post 提交参数</a>
	<hr>
	<h2>我们使用一个form 表单，@requestBody 无法接收参数</h2>
	<form action="${pageContext.request.contextPath}/json/test.action" method="post">
		uid: <input type="text" name="uid"><br>
		username: <input type="text" name="username"><br>
		password: <input type="password" name="password"><br>
		<input id="test2" type="submit" name="submit"><br>
	</form>
	<hr>
	<h2>我们使用  $.ajax 提交请求参数，并且把contentType 改成  application/json, @RequestBody 才能接解析数据</h2>
	<a href="" id="test3">$.ajax 提交json 数据</a>
	<hr>
	<h2>看一下 HttpEntity 能不能接收json 数据</h2>
	<a href="" id="test4">$.ajax 提交json 数据</a>
	<hr>
	<h2>看一下 HttpEntity 能不能接收正常的表单数据</h2>
	<form action="${pageContext.request.contextPath}/json/test3.action">
		uid: <input type="text" name="uid"><br>
		username: <input type="text" name="username"><br>
		password: <input type="password" name="password"><br>
		<input type="submit" name="submit"><br>
	</form>
	
	<hr>
	<h2>看一下HttpEntity 作为返回值能不能返回 user 对象</h2>
	<a href="${pageContext.request.contextPath}/json/test4.action">HttpEntity作为返回值1</a>
	
	<hr>
	<h2>异步请求，看一下HttpEntity 作为返回值能不能把 user 对象转换成 json 格式数据并返回</h2>
	<a id="test5" href="">HttpEntity作为返回值2</a>
	
	<hr>
	<h2>看一下HttpEntity 作为入参可以携带哪些请求头信息</h2>
	<a id="test6" href="">HttpEntity作为入参</a>
	
	<hr>
	<h2>看一下HttpEntity 作为返回值可以如何设置请求头信息</h2>
	<a id="test7" href="">HttpEntity作为返回值</a>
	
	<hr>
	<h2>看一下HttpEntity 能不能通过设置响应头信息实现重定向 </h2>
	<a href="${pageContext.request.contextPath }/json/test7">HttpEntity作为返回值2</a>
	
	<hr>
	<h2>看一下HttpEntity 能不能通过设置响应头信息实现文件下载 </h2>
	<a  href="${pageContext.request.contextPath }/json/test8">HttpEntity作为返回值3</a>
	
	<hr>
	<h2>看一下@ResponseBody 能不能实现文件下载 </h2>
	<a  href="${pageContext.request.contextPath }/json/test9">@ResponseBody 实现文件下载</a>
</body>
</html>