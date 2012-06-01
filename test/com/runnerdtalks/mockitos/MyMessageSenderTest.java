package com.runnerdtalks.mockitos;

import org.junit.Test;

public class MyMessageSenderTest {

	private static final int PORT = 1234;
	
	
	@Test
	public void meuTest() {
		MyMessageSender messageSender = new MyMessageSender("hostname", PORT);
		messageSender.connect();
		
		messageSender.send("Uma Mensagem");
		
		
		
	}
}
