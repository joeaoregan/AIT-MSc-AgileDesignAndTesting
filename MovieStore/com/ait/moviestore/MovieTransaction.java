package com.ait.moviestore;

import com.ait.movie.Movie;

/**
 * Class used to store information about a movie which has been downloaded by a customer.
 */
public class MovieTransaction {


	private final Account account;

	public Account getAccount() {
		return account;
	}

	public Movie getMovie() {
		return movie;
	}

	private final Movie movie;

	/**
	 * Create a new DVD Rental agreement.
	 * @param account the account which is renting the DVD.
	 * @param rentedDvd the DVD which is being rented.
	 */
	public MovieTransaction(final Account account, final Movie movie) {
		this.account = account;
		this.movie = movie;
	}

}
