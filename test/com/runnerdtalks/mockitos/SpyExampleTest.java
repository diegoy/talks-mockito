package com.runnerdtalks.mockitos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class SpyExampleTest {
	
	@Test 
	public void simpleSpyTest() {
		List<String> listaSpy = new ArrayList<String>();
		listaSpy = Mockito.spy(listaSpy);
		listaSpy.add("item1");
		assertEquals("item1", listaSpy.get(0));
		
		when(listaSpy.get(0)).thenReturn("outra coisa");
		//doReturn("outra coisa").when(listaSpy).get(0); //se preferir use desse jeito
		assertEquals("outra coisa", listaSpy.get(0));
	}	
}
