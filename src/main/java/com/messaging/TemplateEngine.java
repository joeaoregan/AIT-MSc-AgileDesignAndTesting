/*
 * L5S66
 * Messaging - Testing Code Using Test Doubles - Ex
 * 11/10/2018
 */
package main.java.com.messaging;

public interface TemplateEngine {
	String prepareMessage(Template msgTemplate, Client client);
}