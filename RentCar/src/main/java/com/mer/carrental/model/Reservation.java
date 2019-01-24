package com.mer.carrental.model;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.mer.carrental.model.Vehicle;
import com.mer.carrental.model.DriverLicence;

/*
 * Class contains reservation info for a single client. 
*/

public class Reservation {

	private DriverLicence lic;
	private Vehicle car;
	ArrayList<RentalDuration> periods;
	double price;
	
	
    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DriverLicence getLic() {
		return lic;
	}

	public void setLic(DriverLicence lic) {
		this.lic = lic;
	}

	public Vehicle getCar() {
		return car;
	}

	public void setCar(Vehicle car) {
		this.car = car;
	}

	public List<RentalDuration> getReserves() {
		return periods;
	}

	public void setReserves(ArrayList<RentalDuration> reserves) {
		this.periods = reserves;
	}

	public Reservation(Vehicle car, DriverLicence lic, ArrayList<RentalDuration> reserves) {
		
		this.lic = lic;
		this.car = car;
		this.periods = reserves;
	}
	
public Reservation(Vehicle car, String licNo, ArrayList<RentalDuration> reserves) {
		
		this.lic = new DriverLicence(licNo);
		this.car = car;
		this.periods = reserves;
	}
	
//Payment due given days booked. Allowing multiple booking periods
	public void calculatePayment(){
		car.getDailyRate();
		int days = 0;
		for(RentalDuration d:periods){
			days += ChronoUnit.DAYS.between(d.getPickupDate(), d.getDropoffDate());
		}
		price  = car.getDailyRate()*++days;
		
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((lic == null) ? 0 : lic.hashCode());
		result = prime * result + ((periods == null) ? 0 : periods.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (lic == null) {
			if (other.lic != null)
				return false;
		} else if (!lic.equals(other.lic))
			return false;
		if (periods == null) {
			if (other.periods != null)
				return false;
		} else if (!periods.equals(other.periods))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [lic=" + lic + ", car=" + car + ", periods=" + periods + ", price=" + price + "]";
	}
	
	
}
