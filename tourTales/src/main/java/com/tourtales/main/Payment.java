package com.tourtales.main;

public class Payment {
	private int id;
	private double amount; 
	private String date;
	
	
	public Payment(int id, double amount, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	} 
	
	public Payment() {
		super();
		this.id = 0;
		this.amount = 0.0;
		this.date = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", date=" + date + "]";
	} 
	
	
}
