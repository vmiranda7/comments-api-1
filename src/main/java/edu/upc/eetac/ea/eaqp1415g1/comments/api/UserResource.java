package edu.upc.eetac.ea.eaqp1415g1.comments.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;

import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.User;
import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.UserCollection;

@Path("/users")
public class UserResource {

	Manager man = new ManagerImpl();

	@POST
	@Consumes(MediaType.COMMENTS_API_USER)
	@Produces(MediaType.COMMENTS_API_USER)
	public User createUser(User user) {
		man.createUser(user);

		return user;
	}

	@PUT
	@Path("/{username}")
	@Consumes(MediaType.COMMENTS_API_USER)
	@Produces(MediaType.COMMENTS_API_USER)
	public User updateUser(@PathParam("username") String username, User user) {
		User u = man.updateUser(username, user);

		return u;
	}

	@GET
	@Produces(MediaType.COMMENTS_API_USER_COLLECTION)
	public UserCollection getUsers() {
		UserCollection users = man.getUsers();

		return users;
	}

	@DELETE
	@Path("/{username}")
	public void deleteUser(@PathParam("username") String username) {
		man.deleteUser(username);
	}
}
