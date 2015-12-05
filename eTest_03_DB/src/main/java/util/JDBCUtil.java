package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection con = null;
		Properties props = new Properties();
		String db_file ="c:/db_info/oracle.properties";
		try{
			props.load(new FileInputStream(db_file));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pwd = props.getProperty("pwd");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pwd);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	public static void close(ResultSet rs , 
			                 PreparedStatement ps,
			                 Connection con) {
		
		try{
			if(rs!=null)  rs.close();
			if(ps!=null)  ps.close();
			if(con!=null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
