package com.tourtales.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tourtales.main.DBUtil;

public class MessageDBUtil {
	public static ArrayList<Message> getMessages(int user_id) {
		ArrayList<Message> messages = new ArrayList<>(); 
		
		String sql = "select * from Message where receiver_id = " + user_id + "";
		ResultSet rs = DBUtil.getQueryResult(sql);
		
		
		try {
			while (rs.next()) {
				int msg_id = rs.getInt(1);
				int sender_id = rs.getInt(2);
				int receiver_id = rs.getInt(3); 
				String message = rs.getString(4);
				String sender_email = UserDBUtil.getEmailFromId(sender_id); 
				
				messages.add(new Message(msg_id, sender_id, receiver_id, message, sender_email)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeCon();
		}
		
		return messages; 
	}
	
	public static void deleteMessage(int id) {
		String sql = "delete from Message where message_id = " + id;
		int rows = DBUtil.changeToTable(sql); 
	}
}
