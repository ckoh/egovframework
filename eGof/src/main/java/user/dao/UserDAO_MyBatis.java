package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import user.vo.UserVO;

@Component("mybatis")
public class UserDAO_MyBatis implements UserDAO {

	@Autowired
	SqlSession sqlSession;

	public UserDAO_MyBatis() {
		System.out.println("create UserDAO_MyBatis");
	}

	@Override
	public UserVO login(UserVO userVO) {

		return sqlSession.selectOne("user.getRowLogin", userVO);
	}

	@Override
	public UserVO login(String id, String pw) {

		UserVO userVO = new UserVO();
		userVO.setUserid(id);
		userVO.setUserpwd(pw);
		return sqlSession.selectOne("user.getRowLogin", userVO);
	}

	@Override
	public int updateUser(UserVO userVO) {

		return sqlSession.update("user.updateRow", userVO);
	}

	@Override
	public UserVO getUser(String id) {

		UserVO userVO = new UserVO();
		userVO.setUserid(id);
		return sqlSession.selectOne("user.getRow", userVO);
	}

	@Override
	public List<UserVO> getUserList() {
		return sqlSession.selectList("user.getGrid");
	}

	@Override
	public int removeUser(String id) {

		return sqlSession.update("user.deleteRow", id);
	}

	@Override
	public int addUser(UserVO userVO) {

		return sqlSession.update("user.insertRow", userVO);
	}

	@Override
	public UserVO search(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserVO> find(UserVO userVO) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("", "");
		
		return sqlSession.selectList("user.search", map);
	}

}
