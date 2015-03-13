package edu.upc.eetac.ea.eaqp1415g1.comments.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.CommentsRootAPI;

@Path("/")
public class CommentsRootAPIResource {
	@GET
	public CommentsRootAPI getRootAPI() {
		CommentsRootAPI api = new CommentsRootAPI();
		return api;
	}
}