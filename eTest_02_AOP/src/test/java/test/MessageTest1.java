package test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageTest1 {

	public static void main(String[] args) {
		String[] c_name = {"applicationContext.xml"};
		ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext(c_name);
		String msg = 
			applicationContext.getMessage("login.success",
					                       new Object[]{"admin"}, 
					                       Locale.CHINESE);
		System.out.println(msg);
	}
}
