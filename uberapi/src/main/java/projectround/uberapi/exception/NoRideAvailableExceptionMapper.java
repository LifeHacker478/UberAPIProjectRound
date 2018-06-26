package projectround.uberapi.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import projectround.uberapi.model.ErrorMessage;

/**
 * This is the mapping class for NoRideAvailableException. By definition it
 * converts it to some meaningful response.
 * 
 * @author Rajat
 *
 */
@Provider
public class NoRideAvailableExceptionMapper implements ExceptionMapper<NoRideAvailableException> {

	@Override
	public Response toResponse(NoRideAvailableException exception) {
		ErrorMessage errorMessag = new ErrorMessage(exception.getMessage(), "404", "https://m.uber.com/");
		return Response.status(Status.NOT_FOUND).entity(errorMessag).build();
	}

}
