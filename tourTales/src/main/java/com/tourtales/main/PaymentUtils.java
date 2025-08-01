package com.tourtales.main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentUtils {
	public static Payment getPayment(int id) {
		
			Payment payment = null; 
			
			String sql = "select * from Payment where payment_ID = " + id; 
			ResultSet rs2 = DBUtil.getQueryResult(sql);
			
			try {
				if (rs2.next()) {				
					double amount = rs2.getDouble(2);
					String date = rs2.getString(3);
					
					payment = new Payment(id, amount, date);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeCon();
			}
			return payment; 
		
	}
}
