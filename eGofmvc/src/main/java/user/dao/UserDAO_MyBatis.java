package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sqlmapper.UserMapper;
import user.vo.UserVO;

/**
 * 이가브 앱스트랙 dao 상속 받아야 한다. : 전자정부는 몇가지 앱스트랙을 상속 받아야 한다.
 * @author student
 *
 */
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
		
		 // 기본
		 // return sqlSession.selectList("user.getGrid");
		
		// 인터페이스 기반 셀렉트
		
		System.out.println("select Test");
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		return mapper.list();
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
