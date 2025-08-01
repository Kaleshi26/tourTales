package com.tourtales.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	private static String url = "jdbc:mysql://localhost:3306/tourTales";
    private static String userName = "tourTalesAdmin";
    private static String password = "Admin@1234";
    private static Connection con;
    private static Statement stmt = null;
    private static ResultSet rs = null; 
    
    
    public static Connection getConnection() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection(url, userName, password);
    	}
    	catch (Exception e) {
    		System.out.println("Database connection is not successful!!");
    	}
    	return con;
    }
    
    
    // get query resultset 
	public static ResultSet getQueryResult(String sql) {
		try {
			con = getConnection();
			stmt = con.createStatement(); 
			System.out.println("executing query: " +sql);
			rs = stmt.executeQuery(sql);			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rs;
	}
	
	// insert into database 
	public static int changeToTable(String sql) {
		int rows = 0;
		try {
			con = getConnection();
			stmt = con.createStatement(); 
			System.out.println("executing query: " +sql);
			rows = stmt.executeUpdate(sql);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		return rows;
	}
	
	// close the connection and free resources
	public static void closeCon() {
		try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
	
	
}
