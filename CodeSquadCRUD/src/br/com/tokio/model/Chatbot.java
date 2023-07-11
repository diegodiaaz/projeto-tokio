package br.com.tokio.model;

public class Chatbot {

	private int id;	
	private String message;

	public Chatbot( String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
