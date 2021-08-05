package com.kgitbank.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelTest {
	
	@Autowired
	private Market market;
	
	@Test
	public void simpleTest() {
		int a = 10;
		int b = 20;
		
		assertEquals(30, a + b); // a + b가 30이면 true, 즉 테스트가 통과된 것
	}

}
