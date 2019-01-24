package com.mer.carrental.app;

import java.util.Optional;

import com.mer.carrental.model.Inventory;
import com.mer.carrental.model.Reservation;
import com.mer.carrental.service.RentalAgent;

public class RentalApplication {

	public static void main(String[] args) {

		String[][] durationArray = {
				// {"2019-01-12", "2019-01-15"},
				// {"2019-01-16", "2019-01-17"},
				{ "2019-01-21", "2019-01-22" } };

		RentalAgent agent = new RentalAgent();
		Inventory.buildFleet();
		Optional<Reservation> re = agent.bookCar("Luxury", "C12345", durationArray);

//		double paymentDue = re.get();
		System.out.println(re.get().toString());
	}
}
