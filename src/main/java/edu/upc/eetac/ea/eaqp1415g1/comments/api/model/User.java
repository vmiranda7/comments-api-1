package edu.upc.eetac.ea.eaqp1415g1.comments.api.model;

public class User {
	private int userid;
	private String username;
	private String password;
	private MessageCollection messages;

	public User() {
		super();
		messages = new MessageCollection();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public MessageCollection getMessages() {
		return messages;
	}

	public void setMessages(MessageCollection messages) {
		this.messages = messages;
	}

}
