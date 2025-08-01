package com.tourtales.main;

public class Booking {
	private int booking_id; 
	private String pickup_loc; 
	private String booking_status;
	private int participants; 
	private String tour_date; 
	private String current_location; 
	private String verification; 
	private double budget; 
	private int payid; 
	private int cusid; 
	private Integer guide_id; 
	private int package_id;
	
	
	
	public Booking() {
		this.booking_id = 0;
		this.pickup_loc = "";
		this.booking_status = "";
		this.participants = 0;
		this.tour_date = "";
		this.current_location = "";
		this.verification = "";
		this.budget = 0.0;
		this.payid = 0;
		this.cusid = 0;
		this.guide_id = null;
		this.package_id = 0;
	}

	public Booking(int booking_id, String pickup_loc, String booking_status, int participants, String tour_date,
			String current_location, String verification, double budget, int payid,
			int package_id,  int cusid, Integer guide_id) {
		this.booking_id = booking_id;
		this.pickup_loc = pickup_loc;
		this.booking_status = booking_status;
		this.participants = participants;
		this.tour_date = tour_date;
		this.current_location = current_location;
		this.verification = verification;
		this.budget = budget;
		this.payid = payid;
		this.cusid = cusid;
		this.guide_id = guide_id;
		this.package_id = package_id;
	}

	public void updateVerifyStatus(String status) {
		String sql = "update Booking set Verification = '" + status + "' where booking_id = " + this.booking_id + ";";
		int rows = DBUtil.changeToTable(sql);
		if (rows > 0) {
			System.out.println("booking verificaiton is updated");
		}
		setVerification(status);
	}
	
	public void updateBookingStatus(String status) {
		String sql = "update Booking set booking_status = '" + status + "' where booking_id = " + this.booking_id + ";";
		int rows = DBUtil.changeToTable(sql);
		if (rows > 0) {
			System.out.println("booking verificaiton is updated");
		}
		setBooking_status(status);
	}
	

	public void updateGuideId(int id) {
		String sql = "update Booking set guide_Id = " + id + " where booking_id = " + this.booking_id + ";";
		int rows = DBUtil.changeToTable(sql);
		if (rows > 0) {
			System.out.println("booking verificaiton is updated");
		}
		setGuide_id(id);
	}
	
	public void checkBookingStatus() {
		if (verification.equals("Verified") && guide_id != null) {
			this.booking_status = "Confirmed";
			updateBookingStatus(this.booking_status);
		} else if (verification.equals("Cancelled")) {
			this.booking_status = "Cancelled";
			updateBookingStatus(this.booking_status);
		}
	}
	

	public int getBooking_id() {
		return booking_id;
	}



	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}



	public String getPickup_loc() {
		return pickup_loc;
	}



	public void setPickup_loc(String pickup_loc) {
		this.pickup_loc = pickup_loc;
	}



	public String getBooking_status() {
		return booking_status;
	}



	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}



	public int getParticipants() {
		return participants;
	}



	public void setParticipants(int participants) {
		this.participants = participants;
	}



	public String getTour_date() {
		return tour_date;
	}



	public void setTour_date(String tour_date) {
		this.tour_date = tour_date;
	}



	public String getCurrent_location() {
		return current_location;
	}



	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}



	public String getVerification() {
		return verification;
	}



	public void setVerification(String verification) {
		this.verification = verification;
	}



	public double getBudget() {
		return budget;
	}



	public void setBudget(double budget) {
		this.budget = budget;
	}



	public int getPayid() {
		return payid;
	}



	public void setPayid(int payid) {
		this.payid = payid;
	}



	public int getCusid() {
		return cusid;
	}



	public void setCusid(int cusid) {
		this.cusid = cusid;
	}



	public Integer getGuide_id() {
		return guide_id;
	}



	public void setGuide_id(int guide_id) {
		this.guide_id = guide_id;
	}



	public int getPackage_id() {
		return package_id;
	}



	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}



	
	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", pickup_loc=" + pickup_loc + ", booking_status=" + booking_status
				+ ", participants=" + participants + ", tour_date=" + tour_date + ", current_location="
				+ current_location + ", verification=" + verification + ", budget=" + budget + ", payid=" + payid
				+ ", cusid=" + cusid + ", guide_id=" + guide_id + ", package_id=" + package_id + "]";
	}

	
	
}
