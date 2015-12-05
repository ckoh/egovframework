package user.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import user.vo.UserVO;

//@Component("ibatis")
@Repository("ibatis")
public class UserDAO_iBatis implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
        System.out.println("UserDAO_iBatis DB 연동");
		return null;
	}

}
