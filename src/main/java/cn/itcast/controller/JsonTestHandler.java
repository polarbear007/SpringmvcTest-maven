package cn.itcast.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.entity.User;

@Controller
@RequestMapping("/json")
public class JsonTestHandler {
	// 如果我们在 User 参数前面添加了 @RequestBody 注解，那么要求必须使用  $ajax 发送请求，而且必须把 contentype
	@RequestMapping("/test")
	public void test(@RequestBody User user, HttpServletResponse response) throws IOException {
		System.out.println(user);
		response.getWriter().write("success");
	}
	
	// 看一下 HttpEntity<T> 能不能接收 json 格式的数据
	@RequestMapping("/test2")
	public void test2(HttpEntity<User> entity, HttpServletResponse response) throws IOException {
		User user = entity.getBody();
		System.out.println(user);
		response.getWriter().write("success");
	}
	
	
	// 看一下 HttpEntity<T> 能不能接收正常表单发送的数据
	// 可以正常提交请求，也不会报异常，也正常跳转。
	// 但是实际上   entity.getBody()  返回的是一个 null 
	@RequestMapping("/test3")
	public String test3(HttpEntity<User> entity, HttpServletResponse response) throws IOException {
		System.out.println(entity.getClass().getName());
		User user = entity.getBody();
		System.out.println(user);
		return "success";
	}
	
	// 看一下 HttpEntity 作为返回值的时候，能不能把  user 对象传到前台去
	// 可 以
	@RequestMapping("/test4")
	public HttpEntity<User> test4(){
		// 自己创建一个 user 对象作为 body 
		User user = new User();
		user.setUid(1);
		user.setUsername("小王");
		user.setPassword("123456");
		// 创建一个   entity 对象作为返回值，并把这个 user 对象作为body 传给 entity 对象
		HttpEntity<User> entity = new HttpEntity<User>(user);
		return entity;
	}
	
	// 看一下 HttpEntity 作为入参的时候，我们可以通过 headers 拿什么信息
	@RequestMapping("/test5")
	public @ResponseBody String test5(HttpEntity<User> entity) {
		// 随便打印一下 user 对象
		System.out.println(entity.getBody());
		
		HttpHeaders headers = entity.getHeaders();
		// 我们可以通过 headers 直接获取很多请求头的信息
		System.out.println("contentType: " + headers.getContentType());
		System.out.println("contentLength: " + headers.getContentLength());
		System.out.println("accept: " + headers.getAccept());
		
		// 如果这些现成的方法没有我们想要的东西，那么我们还可以直接拿到那个 map 对象，那map 对象里面找
		Map<String, String> map = headers.toSingleValueMap();
		System.out.println("user-agent： " + map.get("user-agent"));
		System.out.println("referer： " + map.get("referer"));
		System.out.println("================================");
		// 好啦，我不会找了，直接全部输出吧
		System.out.println(headers);
		
		// 其实我们没有什么可返回的，但是异步请求总是等着我们返回点什么东西，所以这里返回个空字符串吧
		return "success";
	}
	
	// 看一下HttpEntity 作为返回值可以如何设置请求头信息
	// 虽然我们有传过来数据，但是这里并不打算接收，重点看返回值
	@RequestMapping("/test6")
	public HttpEntity<String> test6() {
		// 因为我们那里只需要返回一个字符串，所以这里body 就写一个字符串数据
		String body = "请求成功";
		// 构造方法要的是一个  MultiValueMap ,而HttpHeader 就是这个接口的实现类
		HttpHeaders headers = new HttpHeaders();
		// 我们可以通过这个 headers 对象添加各种响应头信息
		// 这里我们返回的字符串是中文，所以会存在乱码问题，我们这里设置一下  content-type 响应头
		headers.add("Content-Type", "text/plain;charset=utf-8");
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		return entity;
	}
	
	// 看一下HttpEntity 作为返回值可以如何设置请求头信息2
	// 通过设置请求头，来实现重定向到百度页面
	@RequestMapping("/test7")
	public HttpEntity<Object> test7(){
		HttpHeaders headers = new HttpHeaders();
		// http://www.baidu.com         
		// http://localhost:8080/Springmvc-Test-maven/index.jsp
		headers.add("location", "http://www.baidu.com");
		// 这个 status 其实就是状态码， HttpStatus 是一个枚举类，而  HttpStatus.FOUND 就是302
		HttpStatus status = HttpStatus.FOUND;
		// 这一次我们使用 HttpEntity 的子类ResponseEntity来设置响应头信息
		ResponseEntity<Object> entity = new ResponseEntity<Object>(null, headers, status);
		return entity;
	}
	
	// 看一下HttpEntity 作为返回值可以如何设置请求头信息3
	// 通过设置请求头，来实现文件下载的功能 
	// 【注意】 这里直接返回一下 byte[] 数组，如果文件太大的话（比如说1G），那么可能就会出现内存溢出问题。
	@RequestMapping("/test8")
	public HttpEntity<byte[]> test8(HttpServletRequest request) throws IOException{
		HttpHeaders headers = new HttpHeaders();
		// 设置文件名称，同时设置文件下载
		// headers.setContentDispositionFormData("attachment", "你好.txt", Charset.forName("utf-8"));
		// 【注意】 这个方法有重载方法，另一个方法是没有指定字符集。 不知道为什么这个方法被废弃，感觉这个方法比较好用
		//       可以直接指定字符集，如果文件名是中文，那么指定  utf-8 才不会出现乱码的问题
		headers.setContentDispositionFormData("attachment", URLEncoder.encode("你好.txt", "utf-8"));
		// 使用 spring 提供的  FileCopyUtils 工具类，把流数据变成字节数组
		byte[] body = FileCopyUtils.copyToByteArray(request.getServletContext().getResourceAsStream("/file/你好.txt"));
		HttpEntity<byte[]> entity = new HttpEntity<>(body, headers);
		return entity;
	}
	
	// 我们对比一下如果使用  @ResponseBody ，如何去设置文件下载
	@RequestMapping("/test9")
	@ResponseBody
	public byte[] test9(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String filename = URLEncoder.encode("你好.txt", "utf-8");
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		return FileCopyUtils.copyToByteArray(request.getServletContext().getResourceAsStream("/file/你好.txt"));
	}
}
