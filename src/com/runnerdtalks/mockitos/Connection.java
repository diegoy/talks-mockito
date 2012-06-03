package com.runnerdtalks.mockitos;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {

	private String hostAddress;
	
	private int port;
	
	private Socket socket;

	private PrintStream printStream;

	private InputStreamReader inputStreamReader;

	public Connection(String hostAddress, int port) {
		super();
		this.hostAddress = hostAddress;
		this.port = port;
	}
	
	public boolean connect() {
		try {
			socket = new Socket(hostAddress, port);
			printStream = getPrintStream();
			inputStreamReader = getOutputStream();
			return true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void sendMessage(String message) {
		printStream.print(message);
		printStream.flush();
	}
	
	private InputStreamReader getOutputStream() throws IOException {
		return new InputStreamReader(socket.getInputStream());
	}

	private PrintStream getPrintStream() throws IOException {
		return new PrintStream(socket.getOutputStream());
	}
}
