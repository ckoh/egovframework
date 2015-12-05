package user.service;

import java.util.List;

import user.vo.UserVO;

public interface UserService {
   public UserVO login(String id,String pw);
   /*public UserVO login(UserVO userVO);*/
   
   public int addUser(UserVO userVO);
   public int updateUser(UserVO userVO);
   public UserVO getUser(String id);
   public List<UserVO> getUserList();
   public int removeUser(String id);
}
