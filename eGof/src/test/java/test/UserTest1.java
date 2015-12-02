package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 import user.dao.UserDAO;
 import user.dao.UserDAO_JDBC;
 import user.dao.UserDAO_MyBatis;
 import user.dao.UserDAO_Spring;
 import user.dao.UserDAO_iBatis;
 import user.service.UserService;
 import user.service.UserServiceImpl;*/


import user.service.UserService;
import user.vo.UserVO;

public class UserTest1 {

	public static void main(String[] args) {

		// dao select
		/* UserDAO_iBatis dao = new UserDAO_iBatis(); */
		/* UserDAO_MyBatis dao = new UserDAO_MyBatis(); */
		/* UserDAO_Spring dao = new UserDAO_Spring(); */
		/* UserDAO dao = new UserDAO_JDBC(); */

		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService service = (UserService) factory.getBean("service");
		
		/*
		Object bean = factory.getBean("userVO");
		System.out.println(bean); */
		
		UserVO user = service.login("admin", "a1234");
		System.out.println(user);

	}
}
