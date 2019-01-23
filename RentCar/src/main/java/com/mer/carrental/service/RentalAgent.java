package com.mer.carrental.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import com.mer.carrental.model.*;

public class RentalAgent {

	// private static List<Vehicle> rentedCars;
	// private static List<Vehicle> availableCars;
	private Set<Reservation> reservations = new HashSet<Reservation>();

	

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public ArrayList<RentalDuration> buildDurations(String[][] periods) {
		// periods.stream().map(a->new RentalDuration(a->a[0], a[1]));
		ArrayList<RentalDuration> durations = new ArrayList<RentalDuration>();
		String pDate = "", dDate = "";
		LocalDate plDate = null, dlDate = null;
		for (String[] a : periods) {
			pDate = a[0];
			dDate = a[1];
			plDate = LocalDate.parse(pDate);
			dlDate = LocalDate.parse(dDate);
			durations.add(new RentalDuration(plDate, dlDate));
		}
		return durations;
	}

	public Optional<Double> bookCar(String type, String lic, String[][] dStrings) {

		List<Vehicle> cars = getAvailableCars();

		Optional<Double> optional = Optional.empty();
		Reservation res = null;
		ArrayList<RentalDuration> durations = buildDurations(dStrings);
		for (Vehicle car : cars) {
			if (car != null && car.getType().equalsIgnoreCase(type)) {
				car.setRented(true);

				res = new Reservation(car, lic, durations);
				res.calculatePayment();
				// reservations.add(res);
				optional = Optional.ofNullable(res.getPrice());

				break;
			}
			// durations.add(res);
		}
		reservations.add(res);
		return optional;
	}

	public Optional<Reservation> modifyReservation(String type, DriverLicence lic, ArrayList<RentalDuration> reserves) {

		List<Vehicle> cars = getAvailableCars();
		// Vehicle car=null;
		Optional<Reservation> optional = Optional.empty();
		for (Vehicle car : cars) {
			if (car != null && car.getType().equalsIgnoreCase(type))
				;
			{
				car.setRented(true);
				optional = Optional.ofNullable(new Reservation(car, lic, reserves));
			}
		}
		return optional;
	}

	// Returns a list of vehicle that are currently rented
	public List<Vehicle> getRentedCars() {
		List<Vehicle> rentedCars = null;
		// fleet.entrySet().stream().filter(x->x.getValue());

		// for (List<Vehicle> cars : fleet.values()) {
		rentedCars = Inventory.getFleet().stream().filter(x -> x.isRented() == true).collect(Collectors.toList());
		// if (car.isRented()) {
		// rentedCars.add(car);
		// }
		// }
		return rentedCars;
	}

	// Returns a list of vehicle that are currently available
	private List<Vehicle> getAvailableCars() {
		List<Vehicle> availableCars = null;
		// fleet.entrySet().stream().filter(x->x.getValue());

		// for (List<Vehicle> cars : fleet.values()) {
		availableCars = Inventory.getFleet().stream().filter(x -> x.isRented() != true).collect(Collectors.toList());
		// if (car.isRented()) {
		// rentedCars.add(car);
		// }
		// }
		return availableCars;

	}

	// Returns the car matching a driving licence
	public Reservation getExistingReservation(DriverLicence licence) {
		/*
		 * if (FLEET.containsKey(licence)) { return FLEET.get(licence); } else
		 */
		Optional<Reservation> re = reservations.stream()
				.filter(r -> r.getLic().getLicenceNo().equals(licence.getLicenceNo())).findAny();
		Reservation res = re.get();

		return res;
	}
}
