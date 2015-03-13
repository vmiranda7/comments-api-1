package edu.upc.eetac.ea.eaqp1415g1.comments.api.model;

public class CommentsError {
	private int status; // Estado del error, 4XX o 5XX
	private String message;

	public CommentsError() {
		super();
	}

	public CommentsError(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
