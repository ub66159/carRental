package com.mer.carrental.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DriverLicence {

	String licenceNo;
	// todo in real lie need to add other fields
	//String driverName;
	//LocalDate dob;
	//String issueState;

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public DriverLicence(String licenceNo) {
		super();
		this.licenceNo = licenceNo;
	}

	@Override
	public String toString() {
		return "DriverLicence [licenceNo=" + licenceNo + "]";
	}
	
}
