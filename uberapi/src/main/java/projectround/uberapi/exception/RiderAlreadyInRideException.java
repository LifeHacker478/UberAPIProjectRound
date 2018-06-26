package projectround.uberapi.exception;

public class RiderAlreadyInRideException extends RuntimeException {

	private static final long serialVersionUID = -2355481462153632616L;
	
	public RiderAlreadyInRideException(String message) { 
		super(message);
	}
    
}
