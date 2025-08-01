package  com.tourlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class tourlistDBUtil {
	public static List<list> validate(String registrationnumber){
		ArrayList<list> list = new ArrayList<>();
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/tourTales";
		String username = "tourTalesAdmin";
		String password = "Admin@1234";
		
		//validate
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			
			String sql = "select * from tourlist where registrationnumber = '"+registrationnumber+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int listID = rs.getInt(1);
				String tourtitle = rs.getString(2);
				String packagename = rs.getString(3);
				String tourcount = rs.getString(4);
				String category  = rs.getString(5);
				String language = rs.getString(6);
				String email = rs.getString(7);
				String contactnumber = rs.getString(8);
				String registrationnumber1 = rs.getString(9);
				String description = rs.getString(10);
				String duration = rs.getString(11);
				String price = rs.getString(12);
				
				list l  = new list(listID,tourtitle,packagename,tourcount,category,language,email,contactnumber,registrationnumber1,description,duration,price);
				
				list.add(l); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		};
		
		return list;
		
	}
	public static boolean inserttourlist(String tourtitle,String packagename,String tourcount,String category,String language,String email,String contactnumber,String registrationnumber,String description,String duration,String price) {
		
		boolean isSuccess = false;
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/tourTales";
		String username = "tourTalesAdmin";
		String password = "Admin@1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String sql = "insert into tourlist values (0,'"+tourtitle+"','"+packagename+"','"+tourcount+"','"+category+"','"+language+"','"+email+"','"+contactnumber+"','"+registrationnumber+"','"+description+"','"+duration+"','"+price+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
		
	}

	
	
	public static boolean updatelist(String listID,String tourtitle,String packagename,String tourcount,String category,String language,String email,String contactnumber,String registrationnumber,String description,String duration,String price) {
		
		boolean isSuccess = false;
		try {
			Connection con = tourguideDBConnect.getConnection();
			Statement stmt = con.createStatement();
			
			String sql = "update tourlist set tourtitle='"+tourtitle+"',packagename = '"+packagename+"',tourcount ='"+tourcount+"',category='"+category+"',language='"+language+"',email='"+email+"',contactnumber='"+contactnumber+"',registrationnumber='"+registrationnumber+"',description='"+description+"',duration='"+duration+"',price='"+price+"' "
					+ "where registrationnumber = '"+registrationnumber+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
						
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static List<list> getlistDetails(String listID){
		
		int convertedlistID = Integer.parseInt(listID);
		
		ArrayList<list> list =new ArrayList<>();
		
		try {
			Connection con = tourguideDBConnect.getConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from tourlist where listID ='"+convertedlistID+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int listID1 = rs.getInt(1);
				String tourtitle = rs.getString(2);
				String packagename = rs.getString(3);
				String tourcount = rs.getString(4);
				String category  = rs.getString(5);
				String language = rs.getString(6);
				String email = rs.getString(7);
				String contactnumber = rs.getString(8);
				String registrationnumber = rs.getString(9);
				String description = rs.getString(10);
				String duration = rs.getString(11);
				String price = rs.getString(12);
				
				list l = new list(listID1,tourtitle,packagename,tourcount,category,language,email,contactnumber,registrationnumber,description,duration,price);
				list.add(l);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean deletelist(String listID) {
	    
	    int convlistID = Integer.parseInt(listID);
	    
	    boolean isSuccess = false;
		try {
	        Connection con = tourguideDBConnect.getConnection();
	        Statement stmt = con.createStatement();
	        
	        String sql = "delete from tourlist where listID='" +convlistID+ "'";
	        
	        int rs = stmt.executeUpdate(sql);
	        
	        if (rs > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	}
	public static boolean isEmailRegistered(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
