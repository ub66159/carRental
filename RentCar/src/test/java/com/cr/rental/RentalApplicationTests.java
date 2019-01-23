package com.cr.rental;

import static org.junit.Assert.*;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

import com.mer.carrental.model.Inventory;
import com.mer.carrental.service.RentalAgent;

public class RentalApplicationTests {

	
	RentalAgent agent;

	@Before
	public void init() {
		agent = new RentalAgent();
		Inventory.buildFleet();
	}

	@Test
	public void bookCar() {
		
		String[][] durationArray = { 
//				{ "2019-01-12", "2019-01-15" }, 
//				{ "2019-01-16", "2019-01-17" },
				{ "2019-01-21", "2019-01-22" } };
		
		Optional<Double> re = agent.bookCar("Luxury", "C12345", durationArray);
		assertNotNull(re.get());
	}
}
