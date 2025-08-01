package models;

public class Packages {
	
	int pid;
	String pname;
	
	public Packages(int id,String pname)
	{
		this.pid=id;
		this.pname=pname;
	}

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}
	
	
}
