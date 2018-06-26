package projectround.uberapi.exception;


/**
 * 
 * This exception is thrown when a cab is not available.
 * @author mirajat
 *
 */
public class NoRideAvailableException extends RuntimeException {

	private static final long serialVersionUID = 2921069227096568721L;
	public NoRideAvailableException(String message) {
		super(message);
	}
    
}
