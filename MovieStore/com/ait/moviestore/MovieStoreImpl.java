package com.ait.moviestore;
import com.ait.DAO.MovieStoreDAO;
import com.ait.download.DownloadServer;
import com.ait.exception.*;
import com.ait.message.MailServer;
import com.ait.movie.Movie;
import com.ait.payment.PayPalFacade;

public class MovieStoreImpl implements MovieStore {


	//private final String manager;
	private final MovieStoreDAO movieStoreDatabase;
	private final DownloadServer downloadServer;
	private final PayPalFacade paypalFacade;
	private final MailServer mailServer;
	
	public MovieStoreImpl(final MovieStoreDAO movieStoreDatabase,final DownloadServer downloadServer,
			final PayPalFacade paypalFacade, final MailServer mailServer){
		this.movieStoreDatabase=movieStoreDatabase;
		this.downloadServer=downloadServer;
		this.paypalFacade=paypalFacade;
		this.mailServer=mailServer;
	}

	@Override
	public Movie downloadMovie(final String accountId, final String movieTitle) throws MovieStoreException {
		final Account account = movieStoreDatabase.findAccountForId(accountId);
		if (account != null) {
			return downloadMovieForValidAccount(movieTitle, account);
		} else {
			throw new MovieStoreUserException(accountId);
		}
	}

	private Movie downloadMovieForValidAccount(final String movieTitle,
			final Account account) throws MovieStoreException {
		final Movie availableMovie= movieStoreDatabase.getAvailableMovieWithTitle(movieTitle);
		if (availableMovie != null) {
			createNewMovieTransaction(availableMovie, account);
			return availableMovie;
		} else {
			throw new MovieNotAvailable("Movie not available for download: "+movieTitle);
		}
	}

	private void createNewMovieTransaction(final Movie movie,final Account account) throws MovieStoreDownloadException{
		try {
			downloadServer.startDownload(movie, account);
			final MovieTransaction download = new MovieTransaction(account, movie);
			movieStoreDatabase.createNewTransaction(download);
		} catch (MovieStoreException e) {
			throw new MovieStoreDownloadException("Problem downloading: "+movie.getTitle());
		}
		paypalFacade.sendAdvice(movie.getChargePerDownload(),account.getAccountId());
		mailServer.send(account.getEmail(), "Download of "+movie.getTitle()+" started");
		
	}
}
