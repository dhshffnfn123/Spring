package com.kgitbank.service;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.kgitbank.service.RSP;


public class RSP_Test {
	String result;
	Logger log = Logger.getLogger(RSP_Test.class);
	
	
	@Test
	public void test() {
		result = new RSP().rsp();;
		
		log.info(result);
		
	}
}
