package com.ait.moviestore;

import com.ait.exception.MovieStoreException;
import com.ait.movie.Movie;

public interface MovieStore {

	/**
	 * Download a movie from this store.
	 * @param accountId the account ID of the user who wishes to download the movie.
	 * @param movieTitle the title of the movie.
	 * @return the movie which has been downloaded.
	 * @throws MovieStoreException if the movie could not be downloaded.
	 */
	 Movie downloadMovie(String accountId, String movieTitle) throws MovieStoreException;
}
