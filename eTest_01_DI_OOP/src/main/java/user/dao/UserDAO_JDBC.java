package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.vo.UserVO;
import util.JDBCUtil;

public class UserDAO_JDBC implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
        System.out.println("UserDAO_JDBC DB 연동");
        String sql = "select * from userinfo "
        		+ "where userid = ? and userpwd = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserVO vo = null;
        try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
        	ps.setString(1, id);
        	ps.setString(2, pw);
        	rs = ps.executeQuery();
        	while (rs.next()) {
				vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setUsername(rs.getString("username"));
				vo.setUserpwd(rs.getString("userpwd"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		return vo;
	}

}
