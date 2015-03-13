package edu.upc.eetac.ea.eaqp1415g1.comments.api;

import java.util.List;

import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.Message;
import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.MessageCollection;
import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.User;
import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.UserCollection;

public interface Manager {
	
	public UserCollection users = new UserCollection();
	
	
	public User createUser(User user);
	
	public User updateUser(String username, User user);
	
	public UserCollection getUsers();
	
	public void deleteUser(String username);
	
	
	public List <User> usersByMessages();
	
	public Message addMessage(String username, Message message);
	
	public Message updateMessage(String username, int commentid, Message message);
	
	public MessageCollection getMessagesByUser(String username);
	
	public void deleteMessage(String username, int commentid);
	
}
