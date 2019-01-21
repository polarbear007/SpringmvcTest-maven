package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamsHandler {
	@RequestMapping("/getInteger")
	public String getInteger(Integer paramId) {
		System.out.println("paramId : " + paramId);
		return "success";
	}
	
	@RequestMapping("/getInteger2")
	public String getInteger2(@RequestParam(name="abc") Integer paramId) {
		System.out.println("paramId : " + paramId);
		return "success";
	}
	
	@RequestMapping("/getInteger3")
	public String getInteger3(@RequestParam(name="paramId", defaultValue="1") Integer paramId) {
		System.out.println("paramId : " + paramId);
		return "success";
	}
}
