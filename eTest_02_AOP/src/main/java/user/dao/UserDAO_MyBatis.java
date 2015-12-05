package user.dao;

import org.springframework.stereotype.Component;

import user.vo.UserVO;

@Component("mybatis")
public class UserDAO_MyBatis implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
        System.out.println("UserDAO_MyBatis DB 연동");
		
        return null;
	}

}
