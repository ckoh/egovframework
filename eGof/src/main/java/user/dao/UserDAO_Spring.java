package user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import user.vo.UserVO;

@Component("spring")
public class UserDAO_Spring implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public UserDAO_Spring() {
		System.out.println("1.create UserDAO_Spring");
	}

	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAO_Spring login");

		String sql = "select * from userinfo where userid = ? and userpwd = ?";
		UserVO vo = null;
		try {
			vo = jdbcTemplate.queryForObject(sql, new Object[] { id, pw },
					new UserRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public UserVO login(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(UserVO userVO) {
		String sql = "insert into userinfo (userid, username, userpwd, email, phone, address) values (?, ?, ?,?,?,?)";
		return jdbcTemplate.update(sql, userVO.getUserid(),
				userVO.getUsername(), userVO.getUserpwd(), userVO.getEmail(),
				userVO.getPhone(), userVO.getAddress());
	}

	@Override
	public int updateUser(UserVO userVO) {
		String sql = "update userinfo set email=?,phone=?,address=? where  userid  = ? ";
		return jdbcTemplate.update(sql, userVO.getEmail(), userVO.getPhone(),
				userVO.getAddress(), userVO.getUserid());
	}

	@Override
	public UserVO getUser(String id) {
		String sql = "select * from userinfo where userid = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				new UserRowMapper());
	}

	@Override
	public List<UserVO> getUserList() {
		String sql = "select * from userinfo";

		RowMapper<UserVO> rowMapper = new RowMapper<UserVO>() {
			@Override
			public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 맵핑 기술함.
				UserVO userVO = new UserVO();
				userVO.setAddress(rs.getString("address") /* address */);
				userVO.setEmail(rs.getString("email")/* email */);
				userVO.setPhone(rs.getString("phone")/* phone */);
				userVO.setUserid(rs.getString("userid")/* userid */);
				userVO.setUsername(rs.getString("username")/* username */);
				userVO.setUserpwd(rs.getString("userpwd")/* userpwd */);
				return userVO;
			}
		};
		return jdbcTemplate.query(sql, /* new UserRowMapper() *//* 주소 참조. */
				rowMapper);
	}

	@Override
	public int removeUser(String id) {
		String sql = "delete from userinfo where  userid  = ? ";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public UserVO search(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

}

class UserRowMapper implements RowMapper<UserVO/* Object */> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		// 맵핑 기술함.
		UserVO userVO = new UserVO();
		userVO.setAddress(rs.getString("address") /* address */);
		userVO.setEmail(rs.getString("email")/* email */);
		userVO.setPhone(rs.getString("phone")/* phone */);
		userVO.setUserid(rs.getString("userid")/* userid */);
		userVO.setUsername(rs.getString("username")/* username */);
		userVO.setUserpwd(rs.getString("userpwd")/* userpwd */);

		return userVO;
	}
}
