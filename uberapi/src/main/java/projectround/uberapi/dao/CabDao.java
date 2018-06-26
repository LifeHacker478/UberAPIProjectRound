package projectround.uberapi.dao;

import java.util.HashMap;
import java.util.Map;

import projectround.uberapi.model.Cab;
import projectround.uberapi.utilpojos.Location;

public class CabDao {

	/*
	 * Stores cab details for some cab id.
	 */
	private static Map<String, Cab> CAB_TABLE = new HashMap<>();

	/*
	 * Stores the location of each cab.
	 */
	private static Map<String, Location> CAB_LOCATION = new HashMap<>();

	/*
	 * Stores if there is request to given cab
	 */
	private static Map<String, String> CAB_REQUESTS = new HashMap<>();

	/*
	 * Stores if the current cab is in ride or not.
	 */
	private static Map<String, Boolean> CAB_IN_RIDE = new HashMap<>();

	/*
	 * Populates the databases with dummy values
	 */
	static {
		Cab cab1 = new Cab("1", "Suresh", "suzuki");
		Location location1 = new Location(1, 5);

		Cab cab2 = new Cab("2", "Vinod", "Dzire");
		Location location2 = new Location(2, 8);

		Cab cab3 = new Cab("3", "Subodh", "Honda");
		Location location3 = new Location(3, 5);

		addCab(cab1, location1);
		addCab(cab2, location2);
		addCab(cab3, location3);

	}

	public static void addCab(Cab cab, Location location) {
		CAB_TABLE.put(cab.getCabId(), cab);
		CAB_LOCATION.put(cab.getCabId(), location);
		CAB_REQUESTS.put(cab.getCabId(), "");
		CAB_IN_RIDE.put(cab.getCabId(), Boolean.FALSE);
	}

	public static Map<String, Location> getCabLocationDetails() {
		return CAB_LOCATION;
	}

	public static Cab getCabByCabId(String cabId) {
		return CAB_TABLE.get(cabId);
	}

	public static Boolean isCabInRide(String cabId) {
		return CAB_IN_RIDE.get(cabId);
	}
	
	public static void startCabRide(String cabId) {
		CAB_IN_RIDE.put(cabId, Boolean.TRUE);
	}
	
	public static void endCabRide(String cabId) {
		CAB_IN_RIDE.put(cabId, Boolean.FALSE);
	}

}
