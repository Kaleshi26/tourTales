package com.tourlist;

import java.sql.Connection;
import java.sql.DriverManager;

public class tourguideDBConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/tourTales";
	private static String username = "tourTalesAdmin";
	private static String password = "Admin@1234";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			System.out.println("Database connection is not success!!!");
		}
		
		return con;
	}
}
