package com.ait.exception;
/**
 * Exception used to indicate some error occurred when processing a 
 * request in a Movie Store.
 */
public abstract class MovieStoreException extends Exception {

	/**
	 * Create a new exception with an error message.
	 * @param message a String explaining the error which occurred.
	 */
	protected MovieStoreException(final String message) {
		super(message);
	}

	// needed because Exceptions must be serializable
	private static final long serialVersionUID = 6013983962125460401L;

}
