package user.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import user.vo.UserVO;

//@Component("ibatis")
@Repository("ibatis")
public class UserDAO_iBatis implements UserDAO {

	@Autowired
	SqlMapClient sqlMapClient;

	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAO_iBatis DB 연동");
		UserVO vo = null;
		try {
		   vo = new UserVO();	
		   vo.setUserid(id);
		   vo.setUserpwd(pw);
           vo = (UserVO) sqlMapClient.queryForObject("login", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		int row = 0;
		try {
           row = sqlMapClient.update("add",user);
		} catch (Exception e) {
           e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateUser(UserVO user) {
		int row = 0;
		try {
           row = sqlMapClient.update("update",user);
		} catch (Exception e) {
           e.printStackTrace();
		}
		return row;
	}

	@Override
	public UserVO getUser(String id) {
		UserVO vo = null;
		try {
           vo = (UserVO) sqlMapClient.queryForObject("getuser",id);
		} catch (Exception e) {
           e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<UserVO> getUserList() {
		List<UserVO> list = null;
		try {
			list = sqlMapClient.queryForList("list");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int removeUser(String id) {
		int row = 0;
		try {
           row = sqlMapClient.update("delete",id);
		} catch (Exception e) {
           e.printStackTrace();
		}
		return row;
	}

}
