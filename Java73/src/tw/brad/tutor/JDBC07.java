package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {

	public static void main(String[] args) {
		System.out.print("Page: ");
		Scanner scanner = new Scanner(System.in);
		int page = scanner.nextInt();
		System.out.println("----");
	
		final int rpp = 10;	// rows per page
		int start = (page - 1)*rpp;
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/brad", prop)){
			
			Statement stmt = conn.createStatement();
			ResultSet rs0 = stmt.executeQuery("SELECT count(*) count FROM food");
			rs0.next();
			int count = rs0.getInt("count");
			int pages = (int)Math.ceil(count * 1.0/ rpp);
			
			 if (page <= 0 || page > pages)
				 throw new MyException("Page ERROR");
			
			String sql = "SELECT * FROM food ORDER BY id LIMIT ?, ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");

				System.out.printf("%s : %s\n", id, name);
			}
			
		}catch(MyException e) {
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}

class MyException extends Exception {
	private String mesg;
	public MyException(String mesg) {this.mesg = mesg;}
	@Override
	public String toString() {
		return mesg;
	}
}


