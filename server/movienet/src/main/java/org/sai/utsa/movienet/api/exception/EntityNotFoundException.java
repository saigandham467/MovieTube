package org.sai.utsa.movienet.api.exception;

public class EntityNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 911686606148990380L;

	
	public EntityNotFoundException(String message)
	{
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable cause)
	{
		super(message,cause);
	}

}

