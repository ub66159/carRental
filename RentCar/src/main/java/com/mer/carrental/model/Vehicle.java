package com.mer.carrental.model;

import java.io.Serializable;

public class Vehicle implements Serializable,Cloneable{

	
	private static final long serialVersionUID = 2462056305192206707L;

	
	public Vehicle(String vin, String type, double dailyRate, boolean isRented) {
		super();
		this.vin = vin;
		this.dailyRate = dailyRate;
		this.type = type;
		this.isRented = isRented;
	}
	
	
	public Vehicle() {
		this.vin = "";
		this.dailyRate = 0;
		this.type = "";
		this.isRented = false;
	}


	String vin;
//	String make; 
//	String model;

//	double mileage;
	double dailyRate;
	String type;
	boolean isRented;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	/*public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}*/
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	public boolean isRented() {
		return isRented;
	}
	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}
	
	
	
	
}
