package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnDB {
	public static Connection getCon() throws SQLException {
		Connection con =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String ip ="192.168.0.45";
			String url ="jdbc:oracle:thin:@"+ip+":1521:xe";
			con =DriverManager.getConnection(url, "scott", "tiger");
			
			return con;
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
			return null;
		}
	}
	
	public static void closing(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	}
	
	public static void closing(Connection con) throws SQLException {
		if(con!=null) con.close();
	}
	
	public static void closing(PreparedStatement pstmt) throws SQLException {
		if(pstmt!=null) pstmt.close();
	}
	
	public static void closing(ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
	}
}
