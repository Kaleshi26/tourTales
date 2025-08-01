package com.tourtales.user;

import com.tourtales.main.DBUtil;

public class Message {
	private int msg_id; 
	private int sender_id; 
	private int receiver_id; 
	private String message;
	private String sender_email; 
	
	public Message() {
		super();
		this.msg_id = 0;
		this.sender_id = 0;
		this.receiver_id = 0;
		this.sender_email = "";
		this.message = "";
	} 
	
	public Message(int msg_id, int sender_id, int receiver_id, String message, String sender_email) {
		super();
		this.msg_id = msg_id;
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
		this.message = message;
		this.sender_email = sender_email; 
	}
	
	public void deleteMessage() {
		String sql = "delete from Message where message_id = " + this.msg_id;
		int rows = DBUtil.changeToTable(sql); 
	}
	
	public void insertNewMessage() {
		String sql = "insert into Message(sender_id, receiver_id, message) values (" + this.sender_id + "," + this.receiver_id + ",'" + this.message + "');";
		int rows = DBUtil.changeToTable(sql);
		
	}

	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getSender_email() {
		return sender_email;
	}

	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}


	
}
