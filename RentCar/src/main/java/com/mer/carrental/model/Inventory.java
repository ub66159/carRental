package com.mer.carrental.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.mer.carrental.model.DriverLicence;

/*A dummy inventory class. 
 * 
 * todo: get the info from external storage
*/

public class Inventory {
	
	
	private static List<Vehicle> fleet = new ArrayList<Vehicle>();
	
	public static List<Vehicle> getFleet() {
		return fleet;
	}

	public static void setFleet(List<Vehicle> fleet) {
		Inventory.fleet = fleet;
	}

	public static void buildFleet() {
		fleet = new ArrayList<Vehicle>();
		Vehicle v = null;
		for (int i = 0; i < 20; i++) {
			v = new Vehicle("E22344" + i, "Economy", 15, false);
			fleet.add(v);
		}

		for (int i = 0; i < 10; i++) {
			v = new Vehicle("S22344" + i, "Standard", 25.6, false);
			fleet.add(v);
		}
		for (int i = 0; i < 10; i++) {
			v = new Vehicle("L22344" + i, "Luxury", 45.2, false);
			fleet.add(v);
		}
	}
	
	
}
