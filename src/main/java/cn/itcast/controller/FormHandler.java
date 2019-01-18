package cn.itcast.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forms")
public class FormHandler {
	
	@RequestMapping("/login")
	public String login(String username, String password, Model model) {
		System.out.println(username + "---" + password);
		model.addAttribute("message", "登陆成功");
		return "message";
	}
	
	// 异步提交并不需要进行页面跳转，所以我们这里没有返回值，直接使用 response 返回数据 
	@RequestMapping("/login2")
	public void login2(String username, String password, HttpServletResponse response) throws IOException {
		System.out.println(username + "---" + password);
		response.getWriter().write("登陆成功");
	}
}
