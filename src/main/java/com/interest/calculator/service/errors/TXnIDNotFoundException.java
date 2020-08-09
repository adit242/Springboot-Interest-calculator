package com.interest.calculator.service.errors;
public class TXnIDNotFoundException  extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String errorMessage;
	
	public TXnIDNotFoundException(String message){
		super(message);
		this.errorMessage = message;
	}

}
