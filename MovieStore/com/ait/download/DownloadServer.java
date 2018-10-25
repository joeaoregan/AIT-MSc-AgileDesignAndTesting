package com.ait.download;

import com.ait.exception.MovieStoreException;
import com.ait.movie.Movie;
import com.ait.moviestore.Account;

public interface DownloadServer {
	public boolean startDownload(Movie movie, Account account)
			throws MovieStoreException;

}
