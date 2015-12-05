package test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

public class MessageTest1 {
	
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ResourceBundleMessageSource bean = (ResourceBundleMessageSource) applicationContext.getBean("messageSource");
		System.out.println(bean.getMessage("login.success", new Object[]{"amdin"}, Locale.KOREA));
		
		String msg = applicationContext.getMessage("login.success", new Object[]{"single"}, Locale.getDefault());
		System.out.println(msg);
		
		/*bean.get*/
	}

}
