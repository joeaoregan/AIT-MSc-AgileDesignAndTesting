package com.ait.exception;

/**
 * General exception for a movie not being available for download.
 */
public class MovieNotAvailable extends MovieStoreException {

	private static final long serialVersionUID = -7844164306968873458L;

	public MovieNotAvailable(final String message) {
		super(message);
	}

}
