package cn.itcast.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.entity.Employees;

// 演示一下 @InitBinder 的具体使用
@Controller
@RequestMapping("/initBinder2")
public class InitBinderHandler2 {
	@InitBinder
	public void getBinder(WebDataBinder binder) {
		// 设置忽略表单中的 firstName 和 gender 参数
		binder.setDisallowedFields("firstName", "gender");
		// 设置表单中必须要有的参数,如果没有这些参数，就会报错
		binder.setRequiredFields("empNo", "birthDate");
		// 设置把特定格式的字符串转成 Date 类型参数
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
		
		// 另一种方法，直接使用addCustomFormatter 方法，添加一个  DateFormatter 对象
//		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
		
	}
	
	
	@RequestMapping("/test")
	public String test(Employees employees) {
		System.out.println(employees);
		return "success";
	}
	
	@RequestMapping("/test2")
	public String test2(Employees employees, Model model) {
		System.out.println(employees);
		model.addAttribute("employees", employees);
		return "employeesResult";
	}
	
}
