

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tx.TxService;
import user.vo.UserVO;

public class DBTest2 {

	public static void main(String[] args) {
		String[] c_name = {"applicationContext.xml"};
		ApplicationContext context =
			new ClassPathXmlApplicationContext(c_name);
		
		TxService service = (TxService) context.getBean("tx");
		
		UserVO user = new UserVO();
		user.setUserid("java01");
		user.setUserpwd("1234");
		user.setUsername("홍길동");
		user.setAddress("대한민국 서울시");
		user.setEmail("j@nnn.com");
		user.setPhone("111-222-9999");
		
		//service.addUser(user, true);
		
		service.print();

	}
}




