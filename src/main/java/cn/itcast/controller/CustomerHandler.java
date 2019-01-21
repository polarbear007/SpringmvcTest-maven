package cn.itcast.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.entity.Customer;
import cn.itcast.validation.group.CustomerAdd;
import cn.itcast.validation.group.CustomerUpdate;

@Controller
@RequestMapping("/customer")
public class CustomerHandler {
	// 【注意】 @Validated 才能添加分组的接口， @Valid 不行
	//        我们这个方法要使用哪一组或者哪几组的校验规则，我们就直接添加对应的 class 对象就可以了
	@RequestMapping("/addCustomer")
	public String addCustomer(@Validated({CustomerAdd.class}) Customer customer, BindingResult bindingResult, Model model) {
		if(bindingResult.hasFieldErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			model.addAttribute("errors", errors);
			return "error";
		}else {
			System.out.println(customer);
			System.out.println("添加客户信息");
			return "success";
		}
	}
	
	@RequestMapping("/updateCustomer")
	public String updateCustomer(@Validated({CustomerUpdate.class}) Customer customer, BindingResult bindingResult, Model model) {
		if(bindingResult.hasFieldErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			model.addAttribute("errors", errors);
			return "error";
		}else {
			System.out.println(customer);
			System.out.println("修改客户信息");
			return "success";
		}
	}
}
