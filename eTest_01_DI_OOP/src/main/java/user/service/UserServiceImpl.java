package user.service;

import user.dao.UserDAO;
import user.vo.UserVO;

public class UserServiceImpl implements UserService{

	UserDAO dao ;
	
	@Override
	public UserVO login(String id, String pw) {
		return dao.login(id, pw);
	}
}
