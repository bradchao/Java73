package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC05 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/brad", prop);
			String sql = "SELECT * FROM food";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String lat = rs.getString("lat");
				String lng = rs.getString("lng");
				System.out.printf("%s : %s : %s : %s\n", id, name, lat, lng);
			}
			
			conn.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		

	}

}
