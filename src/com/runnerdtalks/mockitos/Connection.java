package com.runnerdtalks.mockitos;

import java.io.BufferedReader;
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

	private BufferedReader bufferedReader;

	public Connection(String hostAddress, int port) {
		super();
		this.hostAddress = hostAddress;
		this.port = port;
	}
	
	public boolean connect() {
		try {
			socket = createSocket();
			printStream = createPrintStream();
			bufferedReader = createInputStream();
			return true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	private Socket createSocket() throws UnknownHostException, IOException {
		return new Socket(hostAddress, port);
	}
	
	public void sendMessage(String message) {
		printStream.print(message);
		printStream.flush();
	}
	
	public String readMessage() {
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			close();
			return null;
		}
	}
	

	private BufferedReader createInputStream() throws IOException {
		return new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	private PrintStream createPrintStream() throws IOException {
		return new PrintStream(socket.getOutputStream());
	}
	
	private void close() {
		try {
			if (socket != null) {
					socket.close();
			}
			if (printStream != null) {
				printStream.close();
			}
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		} catch (IOException e) {
			// nothing to do
		}
	}
}
