package user.dao;

import java.util.List;

import user.vo.UserVO;

/*@Component*/
public interface UserDAO {
	   public UserVO login(String id,String pw);
	   public UserVO login(UserVO userVO);
	 
	   public int addUser(UserVO userVO);
	   public int updateUser(UserVO userVO);
	   public UserVO getUser(String id);
	   public List<UserVO> getUserList();
	   public int removeUser(String id);
	   public UserVO search(UserVO userVO);
	   
}
