package com.transaction;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	
	private static String url = "jdbc:mysql://localhost:3306/bankdb?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String password = "root123";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failure in connecting to database");
		}
		
		return con;
	}
}
