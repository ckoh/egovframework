package user.dao;

import user.vo.UserVO;

public class UserDAO_MyBatis implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
        System.out.println("UserDAO_MyBatis DB 연동");
		
        return null;
	}

}
