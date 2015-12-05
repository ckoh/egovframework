package tv1;

import java.util.Calendar;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TVUser1 {

	public static void main(String[] args) {
		String[] c_name = {"applicationContext.xml"};
		//BeanFactory factory = new BeanFactory();
//		BeanFactory factory =
//        new XmlBeanFactory(new ClassPathResource(c_name));
//	
		ApplicationContext factory = 
		    new ClassPathXmlApplicationContext(c_name);		
//				
		TV user = (TV) factory.getBean("l");
		TV user1 =  factory.getBean("l",TV.class);
		System.out.println("default scope => singletone ?"
		                        +(user==user1));
//		user.powerOn();
//		user.volumeUp();
//		user.powerOff();
		
//		Calendar cal = (Calendar) factory.getBean("cal");
//        System.out.println(cal);
	}
}






