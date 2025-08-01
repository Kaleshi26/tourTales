package com.tourtales.staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tourtales.main.Booking;
import com.tourtales.main.DBUtil;

public class BookingDB {
	public static ArrayList<Booking> getNewBookings() {
		ArrayList<Booking> bookings = new ArrayList<>(); 
		
		String sql = "select * from Booking where booking_status = 'Pending';";
		try {
			ResultSet rs = DBUtil.getQueryResult(sql);
			
			while (rs.next()) {
				int booking_id = rs.getInt(1); 
				String pickup_loc = rs.getString(2); 
				String booking_status = rs.getString(3);
				int participants = rs.getInt(4); 
				String tour_date = rs.getString(5); 
				String current_location  = rs.getString(6); 
				String verification  = rs.getString(7); 
				double budget = rs.getDouble(8); 
				int payid = rs.getInt(9); 
				int package_id = rs.getInt(10);
				int cusid = rs.getInt(11); 
				Integer guide_id = rs.getInt(12) == 0 ? null : rs.getInt(12); 
								
				
				bookings.add(new Booking(booking_id, pickup_loc, booking_status, participants, tour_date, current_location, verification, budget, payid, package_id, cusid, guide_id));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		
		return bookings; 
	}
	
	public static Booking getBooking(int id) {
		Booking booking = null;
		
		String sql = "select * from Booking where booking_id = " + id + ";";
		try {
			ResultSet rs = DBUtil.getQueryResult(sql);
			
			if (rs.next()) {
				int booking_id = rs.getInt(1); 
				String pickup_loc = rs.getString(2); 
				String booking_status = rs.getString(3);
				int participants = rs.getInt(4); 
				String tour_date = rs.getString(5); 
				String current_location  = rs.getString(6); 
				String verification  = rs.getString(7); 
				double budget = rs.getDouble(8); 
				int payid = rs.getInt(9); 
				int package_id = rs.getInt(10);
				int cusid = rs.getInt(11); 
				Integer guide_id = rs.getInt(12) == 0 ? null : rs.getInt(12); 

				
				booking = new Booking(booking_id, pickup_loc, booking_status, participants, tour_date, current_location, verification, budget, payid, package_id, cusid, guide_id);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		
		return booking; 
	}
}
