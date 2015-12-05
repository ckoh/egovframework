package test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tx.TxService;
import user.service.UserService;
import user.vo.UserVO;

public class TxTest {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TxService service = (TxService) applicationContext.getBean("tx");

		UserVO userVO = new UserVO();

		// jdbc
		userVO.setAddress("oh2222" /* address */);
		userVO.setEmail("oh2222"/* email */);
		userVO.setPhone("oh2222"/* phone */);
		userVO.setUserid("oh2222"/* userid */);
		userVO.setUsername("oh2222"/* username */);
		userVO.setUserpwd("oh2222"/* userpwd */);
		service.print();
		// service.addUser(userVO, true);
	}
}
