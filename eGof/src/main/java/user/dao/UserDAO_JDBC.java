package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import user.vo.UserVO;
import util.JDBCUtil;

@Component("jdbc")
public class UserDAO_JDBC implements UserDAO {

	@Override
	public UserVO login(String id, String pw) {

		System.out.println("UserDAO_JDBC login");

		String sql = "select * from userinfo " + "where userid = ? and userpwd = ?";

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
		} finally {
			JDBCUtil.close(rs, ps, con);
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

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int row = 0;

		try {

			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			// 프리페어 스테이트 먼트 셋터 작업 preparedStatement setter
			preparedStatement.setString(1, userVO.getUserid());
			preparedStatement.setString(2, userVO.getUsername());
			preparedStatement.setString(3, userVO.getUserpwd());
			preparedStatement.setString(4, userVO.getEmail());
			preparedStatement.setString(5, userVO.getPhone());
			preparedStatement.setString(6, userVO.getAddress());

			// 실행
			row = preparedStatement.executeUpdate();

			// 결과

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}

		return row;
	}

	@Override
	public int updateUser(UserVO userVO) {
		String sql = "update userinfo set email=?,phone=?,address=? where  userid  = ? ";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int row = 0;

		try {

			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			// 프리페어 스테이트 먼트 셋터 작업 preparedStatement setter
			preparedStatement.setString(1, userVO.getEmail());
			preparedStatement.setString(2, userVO.getPhone());
			preparedStatement.setString(3, userVO.getAddress());
			preparedStatement.setString(4, userVO.getUserid());

			// 실행
			row = preparedStatement.executeUpdate();

			//

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}

		return row;

	}

	@Override
	public UserVO getUser(String id) {
		String sql = "select * from userinfo where userid = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		UserVO vo = new UserVO();

		try {
			
			// 사용
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			// 프리페어 스테이트 먼트 셋터 작업 preparedStatement setter
			preparedStatement.setString(1, id);

			// 실행
			resultSet= preparedStatement.executeQuery();
			
			// 결과
			while (resultSet.next()) {
				
				vo.setAddress(resultSet.getString("address"));
				vo.setEmail(resultSet.getString("email"));
				vo.setPhone(resultSet.getString("phone"));
				vo.setUserid(resultSet.getString("userid"));
				vo.setUsername(resultSet.getString("username"));
				vo.setUserpwd(resultSet.getString("userpwd"));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}

		return vo;
	}

	@Override
	public List<UserVO> getUserList( ) {
		String sql = "select * from userinfo ";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<UserVO> list = new ArrayList<UserVO>();
		
		try {

			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			// 프리페어 스테이트 먼트 셋터 작업 preparedStatement setter
			resultSet = preparedStatement.executeQuery(sql);
			
			// 실행
			
			// 결과
			while (resultSet.next()) {
				UserVO vo = new UserVO();
				vo.setAddress(resultSet.getString("address"));
				vo.setEmail(resultSet.getString("email"));
				vo.setPhone(resultSet.getString("phone"));
				vo.setUserid(resultSet.getString("userid"));
				vo.setUsername(resultSet.getString("username"));
				vo.setUserpwd(resultSet.getString("userpwd"));
				list.add(vo);
			}
			
			//

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}

		return list;
	}

	@Override
	public int removeUser(String id) {
		
		String sql = "delete from userinfo where  userid  = ? ";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UserVO vo = null;
		int row = 0;

		try {

			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			// 프리페어 스테이트 먼트 셋터 작업 preparedStatement setter
			preparedStatement.setString(1, id);
			
			row  = preparedStatement.executeUpdate();
			// 실행
			//

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}

		return row;
	}

	@Override
	public UserVO search(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
