/*
 * L5S66
 * Messaging - Testing Code Using Test Doubles - Ex
 * 11/10/2018
 */
package ait.adt.lec5.messaging;
//package main.java.com.messaging;

public interface MailServer {
	void send(String email, String msgContent);
	void send(Client client, String msgContent);
}
