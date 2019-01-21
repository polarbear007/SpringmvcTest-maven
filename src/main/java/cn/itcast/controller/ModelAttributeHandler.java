package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.entity.User;

@Controller
@RequestMapping("/modelAttribute")
public class ModelAttributeHandler {
	@ModelAttribute
	public void populateModel(User user, Model model) {
		System.out.println("执行了 populateModel() 方法,把 user 对象放进 model 对象");
		model.addAttribute("user", user);
	}
	
	@ModelAttribute("user2")
	public User populateModel2() {
		System.out.println("执行了 populateModel2() 方法,把 user2 对象放进 model 对象");
		User user = new User();
		user.setUid(2);
		user.setUsername("lala");
		user.setPassword("123456");
		return user;
	}
	
	@RequestMapping("/test1")
	public String test1() {
		System.out.println("test1()啥事儿也不干！");
		return "result";
	}
	
	
	@RequestMapping("/test2")
	public String test2(@ModelAttribute("user2") User user) {
		System.out.println(user);
		return "result";
		// 演示一下配置了  《mvc:view-controller 》 以后，能不能直接重定向到  /web-inf 目录下的资源 
		//return "redirect:/toResult";
	}
}
