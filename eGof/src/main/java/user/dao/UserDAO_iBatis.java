package user.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import user.vo.UserVO;

// @Component("ibatis")
@Repository("ibatis")
public class UserDAO_iBatis implements UserDAO{
	
	/*sql*/
	@Autowired
	SqlMapClient sqlMapClient;
	
	public UserDAO_iBatis() {
		System.out.println("create UserDAO_iBatis UserDAO_iBatis");
	}
	
	@Override
	public UserVO login(String id, String pw) {
        
		
		System.out.println("UserDAO_iBatis DB 연동");
		
		UserVO userVO = null;
		try {
			UserVO vo = new UserVO();
			vo.setUserid(id);
			vo.setUserpwd(pw);
			userVO = (UserVO) sqlMapClient.queryForObject("getRowLogin", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}		
        
		return userVO;
	}

	@Override
	public UserVO login(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(UserVO userVO) {
		
		int row = -1;
		
		try {
			row = sqlMapClient.update("updateRow",userVO );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public UserVO getUser(String id) {
		
		UserVO userVO = null;
		
		try {
			
			UserVO vo = new UserVO();
			vo.setUserid(id);
			userVO = (UserVO) sqlMapClient.queryForObject("getRow", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userVO;
	}

	@Override
	public List<UserVO> getUserList() {
		
		List<UserVO> list = null;
		try {
			list = sqlMapClient.queryForList("getGrid");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int removeUser(String id) {
		
		int row = -1;
		try {
			row = sqlMapClient.update("deleteRow", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public int addUser(UserVO userVO) {
		
		int row = -1;
		try {
			row = sqlMapClient.update("insertRow", userVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public UserVO search(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
