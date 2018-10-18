/*
 * L5S64
 * Messaging - Testing Code Using Test Doubles - Ex
 * 11/10/2018
 */
package ait.adt.lec5.messaging;
//package main.java.com.messaging;

public class Messanger {
	private TemplateEngine templateEngine;
	private MailServer mailServer;
	
	public Messanger(MailServer mailServer, TemplateEngine templateEngine) {
		this.mailServer = mailServer;
		this.templateEngine = templateEngine;
	}
	
	public void sendMessage(Client client, Template template) {
		String msgContent = templateEngine.prepareMessage(template, client);
		mailServer.send(client.getEmail(), msgContent);
	}
}
