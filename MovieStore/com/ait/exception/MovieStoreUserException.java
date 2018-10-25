package com.ait.exception;

public class MovieStoreUserException extends MovieStoreException {

	private static final long serialVersionUID = 334051992916748022L;

	public MovieStoreUserException(final String movieTitle) {
		super("Unable to download: "+ movieTitle);
	}

}
