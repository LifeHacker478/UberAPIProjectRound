package projectround.uberapi.manager;

import java.util.Map;

import projectround.uberapi.dao.CabDao;
import projectround.uberapi.dao.RiderDao;
import projectround.uberapi.model.Cab;
import projectround.uberapi.model.Rider;
import projectround.uberapi.utilpojos.Location;


/**
 * The Orchestrator class to take requests from the APIs and forward it to DAO.
 * @author Rajat
 *
 */
public class CabBookManager {

	private int maxPossibleDistance = 10;
	private int farePerUnit = 50;

	public Cab bookCab(Rider rider) {
		Location riderLocation = new Location(rider.getxCordinate(), rider.getyCordinate());

		Map<String, Location> cabLocationDetails = CabDao.getCabLocationDetails();

		int minDistance = 99999999;
		Cab nearestCab = null;

		// finding the nearest rider
		for (Map.Entry<String, Location> entry : cabLocationDetails.entrySet()) {
			String cabId = entry.getKey();
			Location cabLocation = entry.getValue();
			int dist = calculateDistance(cabLocation, riderLocation);
			Cab cab = CabDao.getCabByCabId(cabId);
			if (CabDao.isCabInRide(cab.getCabId()) || dist > maxPossibleDistance) {
				continue;
			}
			if (dist < minDistance) {
				minDistance = dist;
				nearestCab = CabDao.getCabByCabId(cabId);
			}
		}

		if (nearestCab != null) {
			RiderDao.updateRiderRidingWith(rider.getRiderId(), nearestCab.getCabId());
			CabDao.startCabRide(nearestCab.getCabId());
		}
		nearestCab.setTotalFare(0);

		return nearestCab;
	}

	public Cab endRide(Rider rider) {
		Location ridersStartPoint = new Location(rider.getxCordinate(), rider.getyCordinate());
		Location ridersEndPoint = new Location(rider.getDropLocationX(), rider.getDropLocationY());

		int distanceTravelled = calculateDistance(ridersStartPoint, ridersEndPoint);

		int fare = farePerUnit * distanceTravelled;

		String cabId = RiderDao.getRiderRidingWith(rider.getRiderId());
		RiderDao.updateRiderRidingWith(rider.getRiderId(), "");
		CabDao.endCabRide(cabId);
		Cab cab = CabDao.getCabByCabId(cabId);
		cab.setTotalFare(fare);
		return cab;
	}

	/*
	 * For simplicity we take Manhatten distace |x1 - x2| + |y1 - y2| 
	 */
	private int calculateDistance(Location location1, Location location2) {
		return Math.abs(location1.getX() - location2.getX()) + Math.abs(location1.getY() - location2.getY());
	}

}
