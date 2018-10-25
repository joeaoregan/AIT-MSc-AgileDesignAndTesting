package com.ait.movie;

public class Movie {

	private final String title;
	private final double chargePerDownload;

	/**
	 * Create a new Movie with the supplied title.
	 * 
	 * @param title
	 *            the title of the Movie.
	 */
	public Movie(final String title, final double chargePerDownload) {
		this.title = title;
		this.chargePerDownload=chargePerDownload;
	}

	/**
	 * Get the charge to download.
	 * 
	 */
	public double getChargePerDownload() {
		return chargePerDownload;
	}

	public String getTitle() {
		return title;
	}

}
