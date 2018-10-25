package com.ait.DAO;

import java.util.List;

import com.ait.movie.Movie;
import com.ait.moviestore.Account;
import com.ait.moviestore.MovieTransaction;

public interface MovieStoreDAO {
	public Account findAccountForId(String accountId);
	public Movie getAvailableMovieWithTitle(String title);
	public void createNewTransaction(MovieTransaction movieDownload);
	public List<MovieTransaction> retrieveUnPaidTransactions();
}
