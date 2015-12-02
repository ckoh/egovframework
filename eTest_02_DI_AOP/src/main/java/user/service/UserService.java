package user.service;

import user.vo.UserVO;

public interface UserService {
   public UserVO login(String id,String pw);
}
