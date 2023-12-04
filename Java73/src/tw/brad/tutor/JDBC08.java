package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.classes.BCrypt;

public class JDBC08 {
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static final String SQL_INSERT = 
		"INSERT INTO member (account,passwd,cname) VALUES (?,?,?)";
	private static final String SQL_CHECK = 
			"SELECT * FROM member WHERE account = ?";	
	
	public static void main(String[] args) {
		// User Input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();
		System.out.print("Name: ");
		String name = scanner.next();
		

		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			// check account
			if (chechAccount(account)) {
				// Insert Into member
				if (addMember(account, passwd, name)) {
					System.out.println("add success");
				}else {
					System.out.println("add failure");
				}
			}else {
				System.out.println("account REPEAT ERROR");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		


	}
	
	
	static boolean chechAccount(String account) {
		
		return true;
	}
	
	static boolean addMember(String account, String passwd, String cname) {
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, account);
			pstmt.setString(2, hashPasswd);
			pstmt.setString(3, cname);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				return true;
			}
		}catch(Exception e) {
			System.out.println(e);
		}		
		return  false;
	}
	

}
