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
public class UserDAO_Spring implements UserDAO{

	@Autowired
	JdbcTemplate template ;
	
	@Override
	public UserVO login(String id, String pw) {
        System.out.println("UserDAO_Spring DB 연동");
        String sql = "select * from userinfo "
        		+ "where userid = ? and userpwd = ?";
        UserVO vo = null;
        try{
		    vo = template.queryForObject(sql, 
				                       new Object[]{id,pw}, 
				                       new UserRowMapper());
        }catch(Exception e){ }
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		String sql = "insert into userinfo "
				+ "(userid, username, userpwd, email, phone,address)"
				+" values (?, ?, ?, ?, ?, ?)";
	
		return template.update(sql, 
				               user.getUserid(),
				               user.getUsername(),
				               user.getUserpwd(),
				               user.getEmail(),
				               user.getPhone(),
				               user.getAddress());
	}

	@Override
	public int updateUser(UserVO user) {
		String sql = "update userinfo "
				+ "set email=?,phone=?,address=? "
				+ "where  userid  = ? ";
		
		return template.update(sql, 
								user.getEmail(),
								user.getPhone(),
								user.getAddress(),
								user.getUserid());
	}

	@Override
	public UserVO getUser(String id) {
		String sql = "select * from userinfo where userid = ?";
		return template.queryForObject(sql, 
				                       new Object[]{id},
				                       new UserRowMapper());
	}

	@Override
	public List<UserVO> getUserList() {
		String sql = "select * from userinfo ";
		return template.query(sql,new RowMapper<UserVO>(){
			@Override
			public UserVO mapRow(ResultSet rs, int index) 
					                  throws SQLException {
				UserVO vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				return vo;
			}
		} );
	}

	@Override
	public int removeUser(String id) {
		String sql = "delete from userinfo where  userid  = ? ";
		return template.update(sql, id);
	}
	class UserRowMapper implements RowMapper<UserVO>{
		@Override
		public UserVO mapRow(ResultSet rs, int index) 
				                  throws SQLException {
			UserVO vo = new UserVO();
			vo.setUserid(rs.getString("userid"));
			vo.setUsername(rs.getString("username"));
			vo.setUserpwd(rs.getString("userpwd"));
			vo.setAddress(rs.getString("address"));
			vo.setEmail(rs.getString("email"));
			vo.setPhone(rs.getString("phone"));
			return vo;
		}
	}
}












