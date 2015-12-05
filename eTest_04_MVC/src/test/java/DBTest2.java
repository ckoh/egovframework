

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.dao.UserDAO_MyBatis;
import user.service.UserService;
import user.vo.UserVO;

public class DBTest2 {

	public static void main(String[] args) {
		String[] c_name = {"applicationContext.xml"};
		ApplicationContext context =
			new ClassPathXmlApplicationContext(c_name);
		
		UserService service = (UserService) context.getBean("service");
		
		UserVO user = new UserVO();
		user.setUserid("java01");
		user.setUserpwd("1234");
		user.setUsername("홍길동");
		user.setAddress("대한민국 서울시");
		user.setEmail("j@nnn.com");
		user.setPhone("111-222-9999");
		//service.addUser(user);
		//service.updateUser(user);
		//service.removeUser(user.getUserid());
		System.out.println("=== List ===");
		List<UserVO> list = service.getUserList();
		for( UserVO data: list){
			System.out.println(data);
		}
		System.out.println("==== getUser====");
		System.out.println(service.getUser("admin"));
		System.out.println("==== Login ===");
		System.out.println(service.login("admin", "a1234"));
		
		System.out.println("===== 검 색 ======");
		UserDAO_MyBatis dao = 
				(UserDAO_MyBatis) context.getBean("mybatis");
		for( UserVO data: dao.find("email", "admin@multicampus.co.kr")){
			System.out.println(data);
		}
		

	}
}




