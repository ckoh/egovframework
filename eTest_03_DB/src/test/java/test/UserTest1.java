package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user.service.UserService;
import user.vo.UserVO;

public class UserTest1 {
	public static void main(String[] args) {
		//UserDAO dao = new UserDAO_JDBC();
		//UserService service = new UserServiceImpl(dao);
		String[] c_name = {"applicationContext.xml"};
		ApplicationContext factory =
			new ClassPathXmlApplicationContext(c_name);
		
		UserService service = (UserService) factory.getBean("service") ;
		UserVO user = service.login("admin", "a1234");
		System.out.println(user);
	}
}