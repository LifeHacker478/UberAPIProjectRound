package projectround.uberapi.dao;

import java.util.HashMap;
import java.util.Map;

import projectround.uberapi.model.Rider;
import projectround.uberapi.utilpojos.Location;

public class RiderDao {

	/*
	 * Store rider details for some rider id
	 */
	private static Map<String, Rider> RIDER_DATA = new HashMap<>();

	/*
	 * Stores which rider is riding with which cab
	 */
	private static Map<String, String> RIDER_RIDING_WITH = new HashMap<>();

	/*
	 * Stores if the current rider is in ride or not.
	 */
	private static Map<String, Boolean> RIDER_IN_RIDE = new HashMap<>();
	
	/*
	 * Stores the drop location of the rider
	 */
	private static Map<String, Location> RIDERS_DROP_LOCATION = new HashMap<>();
	

	/*
	 * Populates the databases with dummy values
	 */
	static {
		Rider rider1 = new Rider("1", "Usuf");
		Location location1 = new Location(1, 8);
		addRider(rider1, location1);

		Rider rider2 = new Rider("2", "Dheeraj");
		Location location2 = new Location(1, 9);
		addRider(rider2, location2);
	}

	public static void addRider(Rider rider, Location location) {
		RIDER_DATA.put(rider.getRiderId(), rider);
		RIDER_IN_RIDE.put(rider.getRiderId(), Boolean.FALSE);
		RIDER_RIDING_WITH.put(rider.getRiderId(), "");
	}

	public static void updateRiderRidingWith(String riderId, String cabId) {
		RIDER_RIDING_WITH.put(riderId, cabId);
	}
	
	public static String getRiderRidingWith(String riderId) {
		return RIDER_RIDING_WITH.get(riderId);
	}
	
	public static Boolean isRiderRiding(String riderId) {
		return RIDER_RIDING_WITH.get(riderId) != null;
	}
	
	public static void updateDropLocation(String riderId, Location location) {
		RIDERS_DROP_LOCATION.put(riderId, location);
	}
}
