package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

// 演示一下 @InitBinder 的执行时机

@Controller
@RequestMapping("/initBinder")
public class InitBinderHandler {
	@InitBinder
	public void getBinder(WebDataBinder binder) {
		System.out.println("@InitBinder 标记的方法执行了....");
	}
	
	// 如果hander 方法没有参数，则不会执行 @initBinder 标注的方法
	@RequestMapping("/test")
	public String test() {
		return "success";
	}
	
	// 如果 handler 带有参数，但是参数是系统自带的参数，那么也不会执行 @initBinder 标注的方法
	@RequestMapping("/test2")
	public String test2(Model model) {
		return "success";
	}
	
	// 如果 handler 带有自定义的参数，那么每次执行前都会先执行 @InitBinder 标注的方法
	@RequestMapping("/test3")
	public String test3(Integer abc) {
		return "success";
	}
}
