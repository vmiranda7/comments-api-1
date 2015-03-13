package edu.upc.eetac.ea.eaqp1415g1.comments.api;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.Message;
import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.MessageCollection;
import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.User;
import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.UserCollection;

public class ManagerImpl implements Manager {

	private static ManagerImpl instance = null;

	public ManagerImpl() {
		super();
	}

	public static ManagerImpl getInstance() {
		return instance;
	}

	public User createUser(User user) {
		if (users.getUsers().containsKey(user.getUsername())) {
			throw new WebApplicationException("Este usuario ya existe",
					Status.CONFLICT);
		} else {
			users.getUsers().put(user.getUsername(), user);
		}

		return user;
	}

	@Override
	public User updateUser(String username, User user) {
		if (!users.getUsers().containsKey(username)) {
			throw new WebApplicationException("Este usuario no existe",
					Status.CONFLICT);
		}

		users.getUsers().remove(username);
		users.getUsers().put(username, user);

		return users.getUsers().get(username);
	}

	@Override
	public void deleteUser(String username) {
		if (!users.getUsers().containsKey(username)) {
			throw new WebApplicationException("Este usuario no existe",
					Status.CONFLICT);
		} else {
			users.getUsers().remove(username);
		}
	}

	@Override
	public UserCollection getUsers() {
		return users;
	}

	@Override
	public List<User> usersByMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message addMessage(String username, Message m) {
		if (!users.getUsers().containsKey(username)) {
			throw new WebApplicationException("Este usuario no existe",
					Status.CONFLICT);
		} else {
			users.getUsers().get(username).getMessages().getComments()
					.put(m.getCommentid(), m);
		}

		return m;
	}

	@Override
	public Message updateMessage(String username, int commentid, Message message) {
		if (!users.getUsers().get(username).getMessages().getComments()
				.containsKey(message.getCommentid())) {
			throw new WebApplicationException("Este comentario no existe",
					Status.CONFLICT);
		}

		users.getUsers().get(username).getMessages().getComments()
				.remove(username);
		users.getUsers().get(username).getMessages().getComments()
				.put(message.getCommentid(), message);

		return users.getUsers().get(username).getMessages().getComments()
				.get(message.getCommentid());
	}

	@Override
	public MessageCollection getMessagesByUser(String username) {
		return users.getUsers().get(username).getMessages();
	}

	@Override
	public void deleteMessage(String username, int commentid) {
		if (!users.getUsers().containsKey(username)) {
			throw new WebApplicationException("Este usuario no existe",
					Status.CONFLICT);
		} else if (!users.getUsers().get(username).getMessages().getComments()
				.containsKey(commentid)) {
			throw new WebApplicationException(
					"Este usuario no tiene este comentario", Status.CONFLICT);
		} else {
			users.getUsers().get(username).getMessages().getComments()
					.remove(commentid);
		}
	}
}
