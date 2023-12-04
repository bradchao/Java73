package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.classes.BCrypt;
import tw.brad.classes.Member;

public class JDBC09 {
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static final String SQL_LOGIN = 
			"SELECT * FROM member WHERE account = ?";	
	
	public static void main(String[] args) {
		// User Input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();

		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			// check account
			Member member;
			if ((member = login(account, passwd)) != null) {
				System.out.println("Welcome, " + member.getCname());
			}else {
				System.out.println("Login Failure");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	static Member login(String account, String passwd) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String hashPasswd = rs.getString("passwd");
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					// OK
					Member member = new Member(rs.getInt("id"), 
							rs.getString("account"), 
							rs.getString("cname"));
					return member;
				}else {
					// ERR
					return null;
				}
				
			}else {
				// ERROR
				return null;
			}

		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	

}
