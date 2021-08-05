package com.kgitbank.quiz;

import org.springframework.stereotype.Component;

@Component
public class Prime {

	public boolean isPrime(int num) {
		
		// 소수인지 아닌지 판별하는 복잡한 코드
		
		return num % 2 == 0 ? true : false;
		
	}
	
	public void veryAwesomeFunction(int num) throws ClassNotFoundException {
		if (num > 0) {
			throw new ClassNotFoundException();
		}
	}
	
}
