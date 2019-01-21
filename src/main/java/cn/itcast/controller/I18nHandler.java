package cn.itcast.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
@RequestMapping("/i18n")
public class I18nHandler {
	// 这里注入一个 messageSource 对象，这个对象其实就是我们在springmvc.xml 里面配置的
	//  ResourceBundleMessageSource 对象，  是 MessageSource 接口的实现类对象
	//  我们可以使用这个对象的 String getMessage(String code, Object[] args, Locale locale)
	//  方法，根据不同的 locale 和 code 从已经加载的资源文件中获取对应的值
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping("/test")
	public void test(HttpServletRequest request, Locale locale) {
		// springmvc 支持直接在handler 里面添加 Locale 参数
		//  我们可以验证一下 LocaleChangeInterceptor 有没有帮我们把   locale 对象保存到 session 里面
		 Object locale2 = request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		 System.out.println(locale == locale2);
		 
		 // 打印一下 locale 的值
		 System.out.println(locale);
		 
		 // 试图根据  code 和  locale 去已经加载的资源文件中获取指定的值
		 String message = messageSource.getMessage("username", null, locale);
		 System.out.println(message);
	}
	
	// 设置跳转页面， 如果这个页面有  <spring:message > 标签，那么这个页面必须通过  handler 转发访问
	// 不能直接放在 webapp 目录下，直接访问。  如果我们直接把这个jsp 页面放在 webapp 目录下，那么会一直报异常。
	@RequestMapping("/testI18nPage")
	public String testI18nPage() {
		return "testI18n";
	}
	
}
