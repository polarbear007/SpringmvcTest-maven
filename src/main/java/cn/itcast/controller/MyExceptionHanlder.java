package cn.itcast.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.exception.MyException;

@Controller
@RequestMapping("/exception")
public class MyExceptionHanlder {
	
	
	// 这个方法会出现除0异常
	// 如果我们什么都不处理的话，最终会直接把异常信息直接扔给浏览器
	@RequestMapping("test1")
	public String test1() {
		System.out.println(10/0);
		return "success";
	}
	
	// 如果我们添加了这个方法，而且这个 @ExceptionHandler 注解里面包含 ArithmeticException.class 参数
	// 那么当上面的 test1() 方法执行时出现ArithmeticException异常，就会自动调用下面的方法进行处理
	// 这里的处理也很简单，我们只是把异常对象放进 ModelAndView 里面，然后跳转到  exceptionPage.jsp 页面
	
	// 【注意】 当我们把 @ExceptionHandler 和  @ResponseStatus 一起使用，这个方法将无法跳转到指定的
	//       exceptionPage.jsp上去 
	@ResponseStatus(reason="除零异常", code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handlerException (Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", e);
		mv.setViewName("exceptionPage");
		return mv;
	}
	
	// 这里会发生数组索引越界的问题，我们在springmvc.xml 里面已经有配置了
	// SimpleMappingExceptionResolver 进行页面跳转， 所以不会直接在浏览器打印异常信息
	//  而是会跳转到指定的错误页面
	@RequestMapping("/test2")
	public String test2() {
		int[] arr = {1, 2, 3};
		System.out.println(arr[10]);
		return "success";
	}
	
	// 这里我们抛了一个自定义的异常类对象
	// 因为这个自定义异常类对象已经使用 @ResponseStatus 进行修饰了
	// 所以当 handler 方法遇到这类异常，都会直接交给  ResponseStatusExceptionResolver 处理
	// 这个异常处理器的处理其实就是返回特定的异常页面
	@RequestMapping("/test3")
	public String test3() throws MyException {
		if(true) {
			throw new MyException();
		}
		return "success";
	}
	
	// 当一个 handler 方法配合  @ResponseStatus 注解使用的时候
	// 如果handler 方法没有发生异常，那么方法本身会执行完毕
	// 但是无法跳转视频，比如下面的方法，不会跳转到  success.jsp 页面
	// 而是会显示一个 404 错误页面
	@ResponseStatus(reason="哈哈哈", code=HttpStatus.NOT_FOUND)
	@RequestMapping("/test4")
	public String test4() {
		return "success";
	}
}
