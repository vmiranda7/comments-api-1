package edu.upc.eetac.ea.eaqp1415g1.comments.api.model;

import java.util.HashMap;

public class MessageCollection {
	private HashMap<Integer, Message> comments;

	public MessageCollection() {
		super();
		comments = new HashMap<Integer, Message>();
	}

	public HashMap<Integer, Message> getComments() {
		return comments;
	}

	public void setComments(HashMap<Integer, Message> comments) {
		this.comments = comments;
	}

}