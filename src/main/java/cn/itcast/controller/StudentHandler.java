package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentHandler {
	@RequestMapping("/test")
	public String test(Student stu, Model model) {
		System.out.println(stu);
		model.addAttribute("stu", stu);
		return "stuResult";
	}
}
