package edu.upc.eetac.ea.eaqp1415g1.comments.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.CommentsError;

// Procesa el formato del error recibido
@Provider
public class WebApplicationExceptionMapper implements
		ExceptionMapper<WebApplicationException> {
	@Override
	public Response toResponse(WebApplicationException exception) {
		CommentsError error = new CommentsError(
				exception.getResponse().getStatus(), exception.getMessage());
		return Response.status(error.getStatus()).entity(error)
				.type(MediaType.COMMENTS_API_ERROR).build();
	}

}
