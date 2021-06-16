package com.accela.exceptions;

public class AddressNotFoundException extends RuntimeException {
     /**
	 * defualt serial version id
	 */
	private static final long serialVersionUID = 1L;

	private long addressId;
     private String message;

	public AddressNotFoundException(long addressId) {
		this.addressId = addressId;
	}

	public AddressNotFoundException(long addressId,String message) {
		super(message);
		this.message = message;
		this.addressId = addressId;
	}

	public long getAddressId() {
		return addressId;
	} 
	
	public String getMessage() {
		return message;
	}    
}
