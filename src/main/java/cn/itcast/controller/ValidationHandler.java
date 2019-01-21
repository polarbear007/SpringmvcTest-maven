package cn.itcast.controller;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.entity.Teacher;

@Validated
@Controller
@RequestMapping("/validation")
public class ValidationHandler {
	// 【注意】 这个BindingResult 必须跟我们要绑定的实体类参数是相邻的
	//        如果在一个方法中，有多个实体类参数需要校验，那么我们需要一个实体类参数对应一个  BindingResult 对象
	//        handlerMethod(@Valid Teacher teacher, BindingResult teacherResult, 
	//                      @Valid Student student, BindingResult studentResult)
	@RequestMapping("/test")
	public String test(@Validated Teacher teacher, BindingResult bindingResult, Model model) {
		if(bindingResult.hasFieldErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fieldError : errors) {
				// 表单中参数的名字
				System.out.println("field: " + fieldError.getField());
				// 哪个校验注解检查出现错误了
				System.out.println("code: " + fieldError.getCodes());
				// 是哪个实体类上的参数出错了
				System.out.println("objectName: " + fieldError.getObjectName());
				// 被拒绝的表单传过来的参数值
				System.out.println("rejectedValue: " + fieldError.getRejectedValue());
				// 校验不通过返回的提示信息，一般我们可以直接在注解上面添加 message 属性
				// 也可以把所有的提示信息，统一写在一个或者多个配置文件中
				// 如果我们没有配置，那么系统会自动给出一个默认的提示信息
				System.out.println("defaultMessage: " + fieldError.getDefaultMessage());
			}
			model.addAttribute("errors", errors);
			return "error";
		}else {
			System.out.println(teacher);
			return "success";
		}
	}
	
	// score 的校验规则是  @Range(min=0, max=100, message="成绩必须在0-100之间") 
	// 但是因为这个 score 参数并不是什么 javabean 参数里面的属性，所以我也不知道在哪里去设置校验的注解
	@RequestMapping("/test2")
	public String test2(@Range(min=0, max=100, message="成绩必须在0-100之间") @Validated  Integer score, BindingResult bindingResult, Model model) {
		if(bindingResult.hasFieldErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fieldError : errors) {
				// 表单中参数的名字
				System.out.println("field: " + fieldError.getField());
				// 哪个校验注解检查出现错误了
				System.out.println("code: " + fieldError.getCode());
				// 是哪个实体类上的参数出错了
				System.out.println("objectName: " + fieldError.getObjectName());
				// 被拒绝的表单传过来的参数值
				System.out.println("rejectedValue: " + fieldError.getRejectedValue());
				// 校验不通过返回的提示信息，一般我们可以直接在注解上面添加 message 属性
				// 也可以把所有的提示信息，统一写在一个或者多个配置文件中
				// 如果我们没有配置，那么系统会自动给出一个默认的提示信息
				System.out.println("defaultMessage: " + fieldError.getDefaultMessage());
			}
			model.addAttribute("errors", errors);
			return "error";
		}else {
			System.out.println(score);
			return "success";
		}
	}
	
	
	@RequestMapping("/test3")
	public String test3(@Validated Teacher teacher, BindingResult bindingResult, Model model) {
		if(bindingResult.hasFieldErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fieldError : errors) {
				// 表单中参数的名字
				System.out.println("field: " + fieldError.getField());
				// 之前我们直接是   fieldError.getCode() ，这个方法只会返回注解的名称
				// 但是其实在封装 fieldError 对象的时候，springmvc 生成了多个 code
				// 我们可以使用   fieldError.getCodes()  获取所有的code 信息
				// codes: [NotNull.teacher.tid, NotNull.tid, NotNull.java.lang.Integer, NotNull]
				// 如果碰巧，我们又配置 xxxx.properties 文件，而且这个properties 文件里面有对应的 code
				// 又碰巧，我们在jsp 页面使用了 springmvc 提供的表单标签，那么在显示错误信息的时候，
				// 就会优先使用 properties 文件里面的配置信息
				System.out.println("codes: " + Arrays.toString(fieldError.getCodes()));
				// 是哪个实体类上的参数出错了
				System.out.println("objectName: " + fieldError.getObjectName());
				// 被拒绝的表单传过来的参数值
				System.out.println("rejectedValue: " + fieldError.getRejectedValue());
				// 校验不通过返回的提示信息，一般我们可以直接在注解上面添加 message 属性
				// 也可以把所有的提示信息，统一写在一个或者多个配置文件中
				// 如果我们没有配置，那么系统会自动给出一个默认的提示信息
				System.out.println("defaultMessage: " + fieldError.getDefaultMessage());
			}
			model.addAttribute("errors", errors);
			return "error";
		}else {
			System.out.println(teacher);
			return "success";
		}
	}
}
