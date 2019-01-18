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
		// 普通的表单提交 
		$(".login").click(function(){
			var username = $(".loginForm > input[name='username']").val();
			var password = $(".loginForm > input[name='password']").val();
			console.log("校验username: " + username);
			console.log("校验password: " + password);
			
			// 因为我们的表单提交按钮是 button 标签，所以我们需要获取表单对象，然后通过表单对象提交表单
			// 如果校验不通过的话，那么我们就不写下面的语句，就不会提交表单了
			$(".loginForm").submit();
			
			// 如果我们的提交按钮是  submit 标签，那么校验通过，不需要获取表单对象提交
			// 但是校验不通过的话，则需要写一个   return false  取消 submit 标签默认的事件
			// 【注意】  建议如果要使用 jquery 提交表单的话，都使用 button 标签
		});
		
		// 异步提交表单数据
		$(".login2").click(function(){
			// 获取表单数据
			var username = $(".loginForm > input[name='username']").val();
			var password = $(".loginForm > input[name='password']").val();
			
			// 模拟校验表单数据
			console.log("校验username: " + username);
			console.log("校验password: " + password);
			
			// 异步提交
			// 【注意】 这里需要把表单的数据封装成一个 js 对象，得自己手动去封装， 如果数据很多的话就会比较麻烦
			//        其实这里不用 js 对象也是没有关系的，可以直接使用 jquery 提供的两个方法把表单数据进行序列化
			//        $(".loginForm").serialize()
			//        $(".loginForm").serializeArray()
			$.post(
				"${pageContext.request.contextPath }/forms/login2",  // url 地址
				{"username": username, "password": password },  // 一个js 对象（key-value）
				function(data){									// 回调函数
					alert(data);
				},
				"text"				// 设置服务端返回的数据格式，可以是text字符串； 也可以是 json 对象
			);
		});
		
		
		$(".login3").click(function(){
			// 把表单数据序列化成   username=jack&password=123     这种形式的字符串
			console.log($(".loginForm").serialize());
			// 把表单数据序列化成一个数组对象 [{name: "username", value: "jack"}, {name: "password", value: "123"}]
			console.log($(".loginForm").serializeArray());
		});
	});
</script>
</head>
<body>
	<form class="loginForm" action="${pageContext.request.contextPath }/forms/login" method="post">
		username: <input type="text" name="username"><br>
		password: <input type="password" name="password"><br>
		<input class="login" type="button" value="普通提交表单">
		<input class="login2" type="button" value="异步提交表单">
		<input class="login3" type="button" value="测试按钮">
	</form>
</body>
</html>