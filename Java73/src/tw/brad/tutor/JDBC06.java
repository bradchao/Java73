package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC06 {

	public static void main(String[] args) {
		System.out.print("Keyword: ");
		Scanner scanner = new Scanner(System.in);
		String key = scanner.next();
		System.out.println("----");
		
		String mykey = "%" + key + "%";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/brad", prop);
			String sql = "SELECT * FROM food WHERE name LIKE ? OR addr LIKE ? OR tel LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mykey);
			pstmt.setString(2, mykey);
			pstmt.setString(3, mykey);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				System.out.printf("%s : %s : %s\n", name, addr, tel);
			}
			
			conn.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		

	}

}
