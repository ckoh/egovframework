package test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;

public class DBTest_Crud {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService service = (UserService) applicationContext
				.getBean("service");

		UserVO userVO = new UserVO();

		// jdbc
		userVO.setAddress("dbms_admin" /* address */);
		userVO.setEmail("dbms_admin"/* email */);
		userVO.setPhone("dbms_admin"/* phone */);
		userVO.setUserid("dbms_admin"/* userid */);
		userVO.setUsername("dbms_admin"/* username */);
		userVO.setUserpwd("dbms_admin"/* userpwd */);
		System.out.println("삽입 : " + service.addUser(userVO));

		userVO = new UserVO();
		userVO.setAddress("dbms_admin" /* address */);
		userVO.setEmail("dbms_admin"/* email */);
		userVO.setPhone("dbms_admin"/* phone */);
		userVO.setUserid("dbms_admin"/* userid */);
		System.out.println("수정 : " + service.updateUser(userVO));
		
		userVO = new UserVO();

		userVO = service.getUser("dbms_admin");
		System.out.println("한건: " + userVO);

		List<UserVO> userList = service.getUserList();
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
			System.out.println("여러건 : " + (UserVO) iterator.next());
		}

		userVO = service.login("dbms_admin", "dbms_admin");
		System.out.println("로그인 : " + userVO);

		System.out.println("삭제 : " + service.removeUser("dbms_admin"));
	}
}
