package models;

import java.math.BigDecimal;

public class Vehiclemodel {
	
	private String name;
	private BigDecimal price;
	private int seats;
	
	public Vehiclemodel(String name,BigDecimal price2,int seats)
	{
		this.name=name;
		this.price=price2;
		this.seats=seats;
	}

	public String getName() {
		return name;
	}
	public BigDecimal getprice() {
		return price;
	}
	public int getseats() {
		return seats;
	}
	

}

