package com.kgitbank.model;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;



public class LombokTest {
	
	// ��Ŭ������ �α��� ����ϴ� �ΰŸ� �����Ѵ�
	Logger logger = Logger.getLogger(LombokTest.class);

	@Test
	public void test() {
		Employee emp = new Employee(10, "Smith", "Allen");
		//System.out.println(emp);
		
		logger.fatal(emp);
		logger.error(emp);
		logger.warn(emp);
		logger.info(emp);
		logger.debug(emp);
		logger.trace(emp);
		
		assertEquals("Lombok Test Fail", 0, emp.getDepartment_id());
		
	}

}
