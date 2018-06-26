package projectround.uberapi.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import projectround.uberapi.exception.NoRideAvailableException;
import projectround.uberapi.manager.CabBookManager;
import projectround.uberapi.model.Cab;
import projectround.uberapi.model.Rider;

@Path("/ride")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RiderResource {

	private CabBookManager cabBookManager = new CabBookManager();

	
	/**
	 * This API books the ride for a user
	 * @author Rajat
	 *
	 */
	@POST
	@Path("/bookRide")
	public Cab getCab(Rider rider) {
		Cab cab = cabBookManager.bookCab(rider);
		if (cab != null) {
			return cab;
		} else {
			 throw new NoRideAvailableException("No rides available now");
		}
	}

	
	/**
	 * This API ends the ride for a user
	 * @author Rajat
	 *
	 */
	@POST
	@Path("/endRide")
	public Cab endRide(Rider rider) {
		Cab cab = cabBookManager.endRide(rider);
		return cab;
	}

}
