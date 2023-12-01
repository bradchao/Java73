package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {

	public static void main(String[] args) {
		// 1. Load Driver
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("OK");
//		} catch (ClassNotFoundException e) {
//			System.out.println(e);
//		}
		//----------------
		
		try {
//			Connection conn = DriverManager.getConnection(
//				"jdbc:mysql://127.0.0.1:3306/brad?user=root&password=root");
			
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://127.0.0.1:3306/brad","root","root");		
			
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/brad",prop);	
			
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM cust";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
			
			//System.out.println("OK2");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}

}
