package com.mer.carrental.model;

import java.time.LocalDate;

/*
 * Class for single rental period
*/

public class RentalDuration {

	private LocalDate pickupDate;
	private LocalDate dropoffDate;
	
	
	public RentalDuration(LocalDate pickupDate, LocalDate dropoffDate) {
		super();
		this.pickupDate = pickupDate;
		this.dropoffDate = dropoffDate;
	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getDropoffDate() {
		return dropoffDate;
	}

	public void setDropoffDate(LocalDate dropoffDate) {
		this.dropoffDate = dropoffDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dropoffDate == null) ? 0 : dropoffDate.hashCode());
		result = prime * result + ((pickupDate == null) ? 0 : pickupDate.hashCode());
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
		RentalDuration other = (RentalDuration) obj;
		if (dropoffDate == null) {
			if (other.dropoffDate != null)
				return false;
		} else if (!dropoffDate.equals(other.dropoffDate))
			return false;
		if (pickupDate == null) {
			if (other.pickupDate != null)
				return false;
		} else if (!pickupDate.equals(other.pickupDate))
			return false;
		return true;
	}
	
	
}
