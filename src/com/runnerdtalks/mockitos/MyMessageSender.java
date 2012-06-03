package com.runnerdtalks.mockitos;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;


public class MyMessageSender {
	
	private Connection connection;

	public MyMessageSender(Connection connection) {
		this.connection = connection;
	}

	public void send(String string) {
		connection.sendMessage(string.toUpperCase());
	}
	
}
