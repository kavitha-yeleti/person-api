package com.accela.exceptions;

public class APIError {

	private int code;
	private String message;

	public APIError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
