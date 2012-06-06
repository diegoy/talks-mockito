package com.runnerdtalks.mockitos;

public class MyMessageReader {

	private Connection connection;
	
	public MyMessageReader(Connection connection) {
		this.connection = connection;
	}

	public String readMessage() {
		return connection.readMessage();
	}
}
