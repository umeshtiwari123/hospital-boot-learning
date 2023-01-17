package com.ty.Hospital_boot.exception;

public class NoSuchIdFoundException  extends RuntimeException{

	private String message="No Such Id To be found in the Database";
	
	public NoSuchIdFoundException(String message) {
		super();
		this.message=message;
	}
	
	public NoSuchIdFoundException() {
		
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
}