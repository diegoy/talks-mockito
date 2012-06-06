package com.runnerdtalks.mockitos;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MyMessageReaderTest {
	
	private MyMessageReader myMessageReader;
	
	private Connection connection;
	
	@Test
	public void readMessageTest() {
		connection = mock(Connection.class);
		
		given(connection.readMessage()).willReturn("minhaMensagem");
//		when(connection.readMessage()).thenReturn("minhaMensagem");
		myMessageReader = new MyMessageReader(connection);
		
		String readedMessage = myMessageReader.readMessage();
		
		assertEquals(readedMessage, "minhaMensagem");
	}
}
