package com.tourtales.user;

public class StaffMember extends User {

	public StaffMember() {
		super();
	}

	public StaffMember(int id, String fName, String lName, String email, String pwd, String contact_no, String dob,
			String country, String permission) {
		super(id, fName, lName, email, pwd, contact_no, dob, country, permission);
	}
}
