package cn.itcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.itcast.entity.Employees;
import cn.itcast.service.impl.EmployeesServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeesHandler {
	@Autowired
	private EmployeesServiceImpl employeesServiceImpl;
	
	public EmployeesHandler() {
		super();
		System.out.println("EmployeesHandler 构造方法执行了.....");
	}

	@RequestMapping("/findAll")
	public String findAll(@RequestParam(defaultValue="1") Integer currentPage, Model mode) {
		Page<Employees> page = PageHelper.startPage(currentPage, 10);
		employeesServiceImpl.findAll();
		mode.addAttribute("page", page);
		return "listAll";
	}
	
	@RequestMapping("/updateEmployeesPage")
	public String updateEmployeesPage(@RequestParam("empNo") Integer empNo, Model mode) {
		Employees employees = employeesServiceImpl.findById(empNo);
		if(employees != null) {
			mode.addAttribute("employees", employees);
			return "updateEmployeesPage";
		}else {
			mode.addAttribute("message", "找不到对应的员工信息");
			return "message";
		}
	}
	
	@RequestMapping("/updateEmployees")
	public String updateEmployees(Employees emp) {
		employeesServiceImpl.updateEmployees(emp);
		return "redirect:/employees/findAll";
	}
	
	@RequestMapping("/addEmployeesPage")
	public String addEmployeesPage() {
		return "addEmployeesPage";
	}
	
	@RequestMapping("/deleteEmployeesById")
	public String deleteEmployeesById(Integer empNo) {
		employeesServiceImpl.deleteEmployeesById(empNo);
		return "redirect:/employees/findAll";
	}
	
	@RequestMapping("/addEmployees")
	public String addEmployees(Employees emp) {
		employeesServiceImpl.addEmployees(emp);
		return "redirect:/employees/findAll";
	}
}
