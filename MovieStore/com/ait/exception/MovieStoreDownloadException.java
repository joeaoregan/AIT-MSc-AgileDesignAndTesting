package com.ait.exception;

public class MovieStoreDownloadException extends MovieStoreException {

	private static final long serialVersionUID = 334051992916748022L;

	public MovieStoreDownloadException(final String accountId) {
		super("Account not found: "+ accountId);
	}

}
