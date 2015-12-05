package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil {
	
	
	// 커넥션 가져오기	
	public static Connection getConnection() {

		String db_file = "/db_info/oracle.properties";
		Properties props = new Properties();

		Connection conn = null;
		try {

			props.load(new FileInputStream(db_file));

			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pwd = props.getProperty("pwd");

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 닫기
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
