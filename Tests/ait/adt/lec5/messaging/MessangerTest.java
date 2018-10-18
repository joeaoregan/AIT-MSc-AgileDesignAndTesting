/*
 * L5S70
 * Messaging - Testing Code Using Test Doubles - Ex
 * 11/10/2018
 */
package ait.adt.lec5.messaging;
//package main.java.com.messaging;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MessangerTest {
	private static final String CLIENT_EMAIL = "some@email.com";
	private static final String MSG_CONTENT = "Meeting time change to 11am";

	@Test
	public void shouldSendEmail() {
		Template template = mock(Template.class);
		Client client = mock(Client.class);
		MailServer mailServer = mock(MailServer.class);
		TemplateEngine templateEngine = mock(TemplateEngine.class);

		Messanger sut = new Messanger(mailServer, templateEngine);

		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
		when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);

		sut.sendMessage(client, template);

		verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
	}

	// L5S72

//	@Test
//	public void testExpectedException() {
//		MockedObject mockObj = mock(MockObject.class);
//		MySubject subject = new MySubject(mockObj);
//		
//		when(subject).someMethodThrowingException();
//		
//		then(caughtException())
//		.isInstanceOf(MyException.class)
//		.hasMessage("My exception message.");
//		
//		verify(mockObj).someCleanup(eq(...));
//	}
}
