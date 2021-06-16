package com.accela.exceptions;

public class PersonNotFoundException extends RuntimeException {
     /**
	 * deafult serial version id
	 */
	private static final long serialVersionUID = 1L;
	private long personId;
     private String message;

	public PersonNotFoundException(long personId) {
		this.personId = personId;
	}
	
	public PersonNotFoundException(long personId, String message) {
		super(message);
		this.message = message;
		this.personId = personId;
	}

	public long getPersonId() {
		return personId;
	}   
	
	public String getMessage() {
		return message;
	}   
}
