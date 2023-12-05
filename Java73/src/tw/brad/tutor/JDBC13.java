package tw.brad.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.brad.classes.Bike;

public class JDBC13 {
	private static final String USER = "root";	
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static final String SQL_UPDATE =
		"UPDATE member SET bike = ? WHERE id = ?";
	
	public static void main(String[] args) {
		Bike b1 = new Bike();
		b1.upSpeed(); b1.upSpeed();
		b1.upSpeed(); b1.upSpeed();
		System.out.println(b1.getSpeed());
		
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setObject(1, b1);
			
			pstmt.setInt(2, 1);
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Update Success");
			}else {
				System.out.println("Update Failure");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
