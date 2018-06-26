package projectround.uberapi.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import projectround.uberapi.model.ErrorMessage;

public class RiderAlreadyInRideExceptionMapper implements ExceptionMapper<RiderAlreadyInRideException> {

	@Override
	public Response toResponse(RiderAlreadyInRideException exception) {
		ErrorMessage errorMessag = new ErrorMessage(exception.getMessage(), "500", "https://m.uber.com/");
		return Response.status(Status.BAD_REQUEST).entity(errorMessag).build();
	}

}
