package user.dao;

import user.vo.UserVO;

public class UserDAO_Spring implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
        System.out.println("UserDAO_Spring DB 연동");
		return null;
	}

}
