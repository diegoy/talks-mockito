package com.runnerdtalks.mockitos;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class MyMessageSenderTest {

	@Test
	public void sendMessageTest() {
		Connection connection = mock(Connection.class);
		
		MyMessageSender messageSender = new MyMessageSender(connection);
		
		messageSender.send("Uma Mensagem");
		
		verify(connection).sendMessage("UMA MENSAGEM");
		
	}
}
