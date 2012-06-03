package com.runnerdtalks.mockitos;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class MyMessageSenderTest {

	private static final int PORT = 1234;
	
	
	@Test
	public void meuTest() {
		Connection connection = mock(Connection.class);
		
		MyMessageSender messageSender = new MyMessageSender(connection);
		
		messageSender.send("Uma Mensagem");
		
		verify(connection).sendMessage("Uma Mensagem");
	}
}
