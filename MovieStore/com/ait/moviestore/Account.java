package com.ait.moviestore;


/**
 * Represents an account holder with the Movie Store.
 */
public class Account {

	private final String name;

	private final String accountId;
	private final String email;

	/**
	 * Create a new  Account.
	 * 
	 * @param name
	 *            the name of the account holder.
	 * @param accountId
	 *            account identity number
	 * @param email
	 *            email address of the account holder
	 */
	public Account(final String accountId, final String name,final String email) {
		this.name = name;
		this.accountId = accountId;
		this.email=email;
	}
	
	public String getAccountId(){
		return accountId;
	}
	public String getEmail(){
		return email;
	}
	public String getName(){
		return name;
	}
}
