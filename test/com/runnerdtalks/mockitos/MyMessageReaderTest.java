package com.runnerdtalks.mockitos;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

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
