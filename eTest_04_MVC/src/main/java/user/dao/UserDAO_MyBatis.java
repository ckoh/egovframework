package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.hsqldb.rights.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sqlmapper.UserMapper;
import user.vo.UserVO;

@Component("mybatis")
public class UserDAO_MyBatis implements UserDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public UserVO login(String id, String pw) {
        System.out.println("UserDAO_MyBatis DB 연동");
		UserVO user = new UserVO();
		user.setUserid(id);
		user.setUserpwd(pw);
        return sqlSession.selectOne("user.login", user);
	}
	@Override
	public int addUser(UserVO user) {
		return sqlSession.insert("user.add",user);
	}
	@Override
	public int updateUser(UserVO user) {
		return sqlSession.update("user.update",user);
	}
	@Override
	public UserVO getUser(String id) {
		return sqlSession.selectOne("user.getuser",id);
	}
	@Override
	public List<UserVO> getUserList() {
		return sqlSession.selectList("user.list");
//		System.out.println("interface 기반 select 처리");
//		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//		return mapper.list();
	}
	@Override
	public int removeUser(String id) {
		return sqlSession.delete("user.delete",id);
	}
	public List<UserVO> find(String condition , String keyword) {
		HashMap<String, String> map =new HashMap<String, String>();
		map.put(condition, keyword);
		return sqlSession.selectList("user.find",map);
	}
}








