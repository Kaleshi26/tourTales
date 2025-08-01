package models;
public class Bookings {
	
	int id;
	String pickup;
	int number;
	String verify;
	int pid;
	
	public Bookings(int id, String pickup,int number,String verify, int pid) {
		
		this.id=id;
		this.number=number;
		this.pickup=pickup;
		this.verify=verify;
		this.pid=pid;
		
	}

	public int getPid() {
		return pid;
	}

	public int getId() {
		return id;
	}

	public String getPickup() {
		return pickup;
	}

	public int getNumber() {
		return number;
	}

	public String getVerify() {
		return verify;
	}

}
