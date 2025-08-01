package com.tourtales.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tourtales.main.DBUtil;

public class UserDBUtil {
	// check email and password, 
	// if it matches it return User object with details, 
	// otherwise it return User object with empty fields
	public static User validate(String email, String pwd) {
		String sql = "select * from User where email = '" + email + "';";
		User user = new User(); 
		ResultSet rs = DBUtil.getQueryResult(sql);
		
		try {
			if (rs.next()) {
				int id = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);
				String Email = rs.getString(4);
				String PWD = rs.getString(5);
				String contact = rs.getString(6);
				String dob = rs.getString(7);
				String country = rs.getString(8); 
				String permission = rs.getString(9);
				System.out.println(id);
				if (pwd.equals(PWD)) {
					if (permission.equals("TG")) {
						sql = "Select * from TourGuide where guide_id = " + id + ";";
						rs = DBUtil.getQueryResult(sql);
						if (rs.next()) {
							String license = rs.getString(2);
							int exp_year = rs.getInt(3); 
							user = new TourGuide(id,fName, lName, Email, PWD, contact, dob, country, permission, license, exp_year);
						}	
					} else {
						user.setDetails(id,fName, lName, Email, PWD, contact, dob, country, permission);
					}
				}
			}
			rs.close();
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
			

		return user;
	}
	
	public static boolean insertNewUser(String fName, String lName, String email, String pwd, String contact_no, String dob,
			String country, String permission) {
		
		if (isEmailExist(email)) {
			return false; 
		}
		
		int user_id = 0;
		String sql = "INSERT INTO User (fname, lname, email, pwd, contact_no, dob, country, permission_level) VALUES ('"+
			fName 
			+"', '" + lName 
			+ "', '" + email 
			+ "', '" + pwd
			+ "', '" + contact_no
			+ "', '" + dob
			+ "', '" + country
			+ "', '" + permission
			+ "');";
		
		int rows = DBUtil.changeToTable(sql);
		
		sql = "Select user_id from User order by user_id desc limit 1;";
		ResultSet rs = DBUtil.getQueryResult(sql); 
		
		try {
			if (rs.next()) {
				user_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		
		if (permission.equals("CUS")) {
			sql = "INSERT INTO Customer values (" + user_id + ");";
			rows = DBUtil.changeToTable(sql);
		} else if (permission.equals("STF")) {
			sql = "INSERT INTO Staff values (" + user_id + ", 'staff');";
			rows = DBUtil.changeToTable(sql);
		}
		
		if (rows > 0) {
			return true;
		} else {
			return false; 
		}
	}
	
	public static boolean insertNewGuide(String fName, String lName, String email, String pwd, String contact_no, String dob,
			String country, String permission, String license, int exp_years) {
		
		if (isEmailExist(email)) {
			return false; 
		}
		
		int user_id = 0;
		String sql = "INSERT INTO User (fname, lname, email, pwd, contact_no, dob, country, permission_level) VALUES ('"+
			fName 
			+"', '" + lName 
			+ "', '" + email 
			+ "', '" + pwd
			+ "', '" + contact_no
			+ "', '" + dob
			+ "', '" + country
			+ "', '" + permission
			+ "');";
		
		int rows = DBUtil.changeToTable(sql);
		
		sql = "Select user_id from User order by desc limit 1";
		ResultSet rs = DBUtil.getQueryResult(sql); 
		
		try {
			if (rs.next()) {
				user_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		
		sql = "INSERT INTO TourGuide values (" + user_id + ", '" + license + "', " + exp_years + ");";
		rows = DBUtil.changeToTable(sql);
		
		return (rows > 0) ? true : false; 
	}
	
	public static boolean isEmailExist(String email) {
		String sql = "select * from User where email = '" + email + "';";
		ResultSet rs = DBUtil.getQueryResult(sql);
		
		try {
			if (!rs.next()) {
				return false; 
			} else {
				System.out.println("email exists");
				return true; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true; 
	}
	
	public static ArrayList<TourGuide> getAllGuides() {
		ArrayList<TourGuide> guides = new ArrayList<>();
		
		String sql = "select * from TourGuide"; 
		ResultSet rs = DBUtil.getQueryResult(sql);
		
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String license = rs.getString(2);
				int exp_year = rs.getInt(3);
				
				sql = "select * from User where user_id = " + id ;
				ResultSet rs2 = DBUtil.getQueryResult(sql);
				rs2.next();
				
				String fName = rs2.getString(2);
				String lName = rs2.getString(3);
				String Email = rs2.getString(4);
				String PWD = rs2.getString(5);
				String contact = rs2.getString(6);
				String dob = rs2.getString(7);
				String country = rs2.getString(8); 
				String permission = rs2.getString(9);
				
				guides.add(new TourGuide(id,fName, lName, Email, PWD, contact, dob, country, permission, license, exp_year));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		return guides; 
	}
	
	public static TourGuide getTourGuide(int guide_id) {
		TourGuide guide = new TourGuide();
		
		String sql = "select * from TourGuide where guide_id = " + guide_id; 
		ResultSet rs = DBUtil.getQueryResult(sql);
		
		try {
			if (rs.next()) {
				int id = rs.getInt(1);
				String license = rs.getString(2);
				int exp_year = rs.getInt(3);
				
				sql = "select * from User where user_id = " + id ;
				ResultSet rs2 = DBUtil.getQueryResult(sql);
				rs2.next();
				
				String fName = rs2.getString(2);
				String lName = rs2.getString(3);
				String Email = rs2.getString(4);
				String PWD = rs2.getString(5);
				String contact = rs2.getString(6);
				String dob = rs2.getString(7);
				String country = rs2.getString(8); 
				String permission = rs2.getString(9);
				
				guide = new TourGuide(id,fName, lName, Email, PWD, contact, dob, country, permission, license, exp_year);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		return guide; 
	}
	
	public static User getCustomer(int id) {
		User user = new User();
		
		String sql = "select * from User where user_id = " + id; 
		ResultSet rs2 = DBUtil.getQueryResult(sql);
		
		try {
			if (rs2.next()) {				
				String fName = rs2.getString(2);
				String lName = rs2.getString(3);
				String Email = rs2.getString(4);
				String PWD = rs2.getString(5);
				String contact = rs2.getString(6);
				String dob = rs2.getString(7);
				String country = rs2.getString(8); 
				String permission = rs2.getString(9);
				
				user = new User(id,fName, lName, Email, PWD, contact, dob, country, permission);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		return user; 
	}
	
	public static User getUser(int id) {
		User user = new User();
		
		String sql = "select * from User where user_id = " + id; 
		ResultSet rs2 = DBUtil.getQueryResult(sql);
		
		try {
			if (rs2.next()) {				
				String fName = rs2.getString(2);
				String lName = rs2.getString(3);
				String Email = rs2.getString(4);
				String PWD = rs2.getString(5);
				String contact = rs2.getString(6);
				String dob = rs2.getString(7);
				String country = rs2.getString(8); 
				String permission = rs2.getString(9);
				
				user = new User(id,fName, lName, Email, PWD, contact, dob, country, permission);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		return user; 
	}
	
	public static User getlatestUser() {
		User user = new User();
		
		String sql = "select * from User order by user_id desc limit 1"; 
		ResultSet rs2 = DBUtil.getQueryResult(sql);
		
		try {
			if (rs2.next()) {	
				int id = rs2.getInt(1);
				String fName = rs2.getString(2);
				String lName = rs2.getString(3);
				String Email = rs2.getString(4);
				String PWD = rs2.getString(5);
				String contact = rs2.getString(6);
				String dob = rs2.getString(7);
				String country = rs2.getString(8); 
				String permission = rs2.getString(9);
				
				user = new User(id,fName, lName, Email, PWD, contact, dob, country, permission);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		return user; 
	}
	
	public static int getIdFromEmail(String email) { 
		String sql = "select * from User where email = '" + email + "';"; 
		ResultSet rs2 = DBUtil.getQueryResult(sql);
		int id = 0; 
		
		try {
			if (rs2.next()) {	
				id = rs2.getInt(1);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		
		return id; 
	}
	
	public static String getEmailFromId(int id) { 
		String sql = "select * from User where user_id = " + id + ";"; 
		ResultSet rs2 = DBUtil.getQueryResult(sql);
		String email = null; 
		
		try {
			if (rs2.next()) {	
				email = rs2.getString(4);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		
		return email; 
	}
}
