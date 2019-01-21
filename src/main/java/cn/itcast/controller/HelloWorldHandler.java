package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 演示一下 @RequestMapping

@Controller
public class HelloWorldHandler {
	@RequestMapping("/hello") 
	public String hello() {
		System.out.println("hello world");
		return "success";
	}
	
	@RequestMapping(value="/hello2")
	public String hello2() {
		System.out.println("hello world2");
		return  "success";
	}
	
	@RequestMapping(value="/hello3.action")
	public String hello3() {
		System.out.println("hello world3");
		return  "success";
	}
	
	// method参数指定请求的类型，只能使用 post 请求方式来请求这个handler 方法
	// 如果我们使用 get 方式请求的话，那么会报下面的错误：
	// HTTP Status 405 - Request method 'GET' not supported
	@RequestMapping(value="/hello4", method=RequestMethod.POST)
	public String hello4() {
		System.out.println("hello world4");
		return  "success";
	}
	
	// params 接收一个字符串数组，里面可以写多个参数名，限制请求中必须带有指定的参数
	// 如果请求中没有带有指定参数的话，那么就会报下面的错误：
	// HTTP Status 400 - Parameter conditions "abc" not met for actual request parameters:
	@RequestMapping(value="/hello5", params= {"abc"})
	public String hello5(String abc) {
		System.out.println("hello world5： abc= " + abc);
		return  "success";
	}
	
	// 要求请求中的请求头里面必须包含：　content-type=application/x-www-form-urlencoded　
	// 我们这里要说一下浏览器 post 请求服务器常见的方式：
	//	application/x-www-form-urlencoded （post 表单默认）
	//	multipart/form-data   			    （主要用于文件上传）
	//	application/json				    （一般使用 ajax 的时候才用这种）
	//	text/xml                           （几乎已经被 json 取代）
	
	// 另外，我们要说一下 header 还定义了非常多的信息，比如 cookies 、 比如User-agent 、 比如 referer 等等
	// 通用对这些 header 信息的限制，我们可以进行非常多的操作。  具体的话，我们可以再回顾一下以前 servlet 的笔记。
	@RequestMapping(value="/hello6", headers= {"content-type=application/x-www-form-urlencoded"})
	public String hello6() {
		System.out.println("hello world6");
		return  "success";
	}
}

