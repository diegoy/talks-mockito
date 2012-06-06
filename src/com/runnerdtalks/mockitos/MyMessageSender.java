package com.runnerdtalks.mockitos;

public class MyMessageSender {
	
	private Connection connection;

	public MyMessageSender(Connection connection) {
		this.connection = connection;
	}

	public void send(String message) {
		connection.sendMessage(message.toUpperCase());
	}

	public void sendMultipleMessages(String... messages) {
		for (String message : messages) {
			send(message);
		}
	}
}
