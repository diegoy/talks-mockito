package com.runnerdtalks.mockitos;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class MyMessageSenderTest {

	private Connection connection;
	private MyMessageSender messageSender;

	@Before
	public void before() {
		connection = mock(Connection.class);
		messageSender = new MyMessageSender(connection);
	}
	
	@Test
	public void sendMessageTest() {
		messageSender.send("Uma Mensagem");
		
		verify(connection).sendMessage("UMA MENSAGEM");
	}
	
	@Test
	public void behaviourTest() {
		messageSender.sendMultipleMessages("Mensagem Um", "Mensagem Dois");
		
		verify(connection, times(2)).sendMessage(anyString());
		verify(connection).sendMessage("MENSAGEM UM");
		verify(connection).sendMessage("MENSAGEM DOIS");
	}
	
}
