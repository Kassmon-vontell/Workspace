package com.kassmon.game.ui.email;

public class Email {
	
	private String sender;
	private String subject;
	private String body;
	private boolean deletable;
	
	public Email(String sender, String subject, String body, boolean deletable) {
		this.sender = sender;
		this.subject = subject;
		this.body = body;
		this.deletable = deletable;
	}
	
	public String getHeader() {
		return sender + ": " + subject;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getBody() {
		return body;
	}
	
	public boolean isDeletable() {
		return deletable;
	}
	
	
}
