package user.service;

import java.util.List;

import user.vo.UserVO;

public interface UserService {
   public UserVO login(String id,String pw);
   public int  addUser(UserVO user);
   public int  updateUser(UserVO user);
   public UserVO  getUser(String id);
   public List<UserVO>  getUserList();
   public int  removeUser(String id);
   
}
