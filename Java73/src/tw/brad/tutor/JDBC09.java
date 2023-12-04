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
	private static final String SQL_CHPASSWD = 
			"UPDATE member SET passwd = ? WHERE id = ?";	
	
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
			
				System.out.print("New Password: ");
				String newpasswd = scanner.next();
				if (chPasswd(member, newpasswd)) {
					System.out.println("New Password changed");
				}else {
					System.out.println("Password change ERROR");
				}
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
	
	static boolean chPasswd(Member member, String newpasswd) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHPASSWD);
			pstmt.setString(1, BCrypt.hashpw(newpasswd, BCrypt.gensalt()));
			pstmt.setInt(2, member.getId());
			int num = pstmt.executeUpdate();
			if (num == 1) {
				return true;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
