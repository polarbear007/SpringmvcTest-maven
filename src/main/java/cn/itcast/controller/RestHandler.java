package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.entity.User;

// 【注意】  rest 风格的网站是会严格区分请求方式的：
//              get ====》 查询
//             post ====》 更新
//			 delete ====》 删除
//           	put ====》 添加

//  但是如果我们在浏览器上使用表单的方式提交请求，只能有 get / post 两种
//  springmvc 提供了一个 org.springframework.web.filter.HiddenHttpMethodFilter  过滤器
//  只要我们的表单格式符合这个过滤器的要求，那么这个过滤器就会帮我们修改请求的类型

//  1、 在web.xml里面配置 org.springframework.web.filter.HiddenHttpMethodFilter ， url-patten 设置成  /*
//  2、 在jsp 页面上，我们全部是使用表单提交，如果是get 或者  post ，那就随意 ； 
//     如果是 delete 和 put 的话，那么就需要添加一个 <input type="hidden" name="_method" value="put或者delete"> 标签

@Controller
@RequestMapping("/rest")
public class RestHandler {
	@RequestMapping("/test")
	public String test() {
		System.out.println("RestHandler test");
		return "success";
	}
	
	@GetMapping("/user")
	public String findUser(Integer uid) {
		System.out.println("RestHandler findUser : " + uid);
		return "success";
	}
	
	@PostMapping("/user")
	public String updateUser(User user) {
		System.out.println("RestHandler updateUser : " + user);
		return "success";
	}
	
	@DeleteMapping("/user")
	public String deleteUser(Integer uid) {
		System.out.println("RestHandler deleteUser : " + uid);
		return "success";
	}
	
	@PutMapping("/user")
	public String addUser(User user) {
		System.out.println("RestHandler addUser : " + user);
		return "success";
	}
	
	// restful 风格传参数还支持把参数直接放在 url 路径上面，我们可以使用 @PathVariable 注解获取参数
	// 很多网站的搜索框，关键词都是直接放在 url 路径上面的
	// 然后还有分页的数据，那个当前页 数据也是经常放在 url 路径上的
	@GetMapping("/pathvariable/user/{uid}")
	public String findUser2(@PathVariable("uid")Integer uid) {
		System.out.println("RestHandler findUser2 : " + uid);
		return "success";
	}
}
