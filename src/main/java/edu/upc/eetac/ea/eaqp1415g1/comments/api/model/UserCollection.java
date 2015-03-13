package edu.upc.eetac.ea.eaqp1415g1.comments.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UserCollection {
	private HashMap<String, User> users;

	public UserCollection() {
		super();
		users = new HashMap<String, User>();
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}
}