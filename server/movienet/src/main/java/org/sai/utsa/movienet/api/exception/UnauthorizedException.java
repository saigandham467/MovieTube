package org.sai.utsa.movienet.api.exception;

public class UnauthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4353143226223968397L;
	public UnauthorizedException(String message)
	{
		super(message);
	}
	public UnauthorizedException(String message,Throwable cause)
	{
		super(message,cause);
	}
	

}
