package com.runnerdtalks.mockitos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class ConnectionTest {

	@Test
	public void shouldReadMessage() throws UnknownHostException, IOException {
		Connection connection = new Connection("127.0.0.1", 14000);
		connection = spy(connection);

		Socket socket = mock(Socket.class);
		BufferedReader bufferedReader = mock(BufferedReader.class);
		PrintStream printStream = mock(PrintStream.class);

		doReturn(socket).when(connection).createSocket();
		doReturn(bufferedReader).when(connection).createInputStream();
		doReturn(printStream).when(connection).createPrintStream();

		when(bufferedReader.readLine()).thenReturn("readed from mock");
		connection.connect();

		assertNotNull(connection.readMessage());
	}

}
