package org.sai.utsa.movienet.api.exception;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4216062213821418611L;

	
	
	public BadRequestException(String message)
	{
		super(message);
	}
	
	public BadRequestException(String message, Throwable cause)
	{
		super(message,cause);
	}
	

}



