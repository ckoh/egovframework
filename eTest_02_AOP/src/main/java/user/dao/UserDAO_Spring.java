package user.dao;

import org.springframework.stereotype.Component;

import user.vo.UserVO;

@Component("spring")
public class UserDAO_Spring implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
        System.out.println("UserDAO_Spring DB 연동");
		return null;
	}

}
