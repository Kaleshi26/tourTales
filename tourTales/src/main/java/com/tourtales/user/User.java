package com.tourtales.user;

public class User {
	protected int id; 
	protected String fName; 
	protected String lName; 
	protected String email; 
	protected String pwd; 
	protected String contact_no; 
	protected String dob; 
	protected String country;
	protected String permission; 
	
	
	public User() {
		super();
		this.id = 0;
		this.fName = "";
		this.lName = "";
		this.email = "";
		this.pwd = "";
		this.contact_no = "";
		this.dob = "";
		this.country = "";
		this.permission = "";
	}

	public User(int id, String fName, String lName, String email, String pwd, String contact_no, String dob,
			String country, String permission) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pwd = pwd;
		this.contact_no = contact_no;
		this.dob = dob;
		this.country = country;
		this.permission = permission;
	}
	
	public void setDetails(int id, String fName, String lName, String email, String pwd, String contact_no, String dob,
			String country, String permission) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pwd = pwd;
		this.contact_no = contact_no;
		this.dob = dob;
		this.country = country;
		this.permission = permission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pwd=" + pwd
				+ ", contact_no=" + contact_no + ", dob=" + dob + ", country=" + country + "]";
	}
	
	
}
