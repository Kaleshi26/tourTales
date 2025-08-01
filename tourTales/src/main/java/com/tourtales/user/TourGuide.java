package com.tourtales.user;

public class TourGuide extends User {
	
	private String license_no; 
	private int exp_year; 
	
	public TourGuide() {
		super();
		this.license_no = "";
		this.exp_year = 0;
	}

	public TourGuide(int id, String fName, String lName, String email, String pwd, String contact_no, String dob,
			String country, String permission, String license_no, int exp_year) {
		
		super(id, fName, lName, email, pwd, contact_no, dob, country, permission);
		this.license_no = license_no;
		this.exp_year = exp_year;
	}

	public String getLicense_no() {
		return license_no;
	}

	public void setLicense_no(String license_no) {
		this.license_no = license_no;
	}

	public int getExp_year() {
		return exp_year;
	}

	public void setExp_year(int exp_year) {
		this.exp_year = exp_year;
	}

	@Override
	public String toString() {
		return "TourGuide [license_no=" + license_no + ", exp_year=" + exp_year + ", id=" + id + ", fName=" + fName
				+ ", lName=" + lName + ", email=" + email + ", pwd=" + pwd + ", contact_no=" + contact_no + ", dob="
				+ dob + ", country=" + country + ", permission=" + permission + "]";
	}



}
