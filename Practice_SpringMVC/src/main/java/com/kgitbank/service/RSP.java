package com.kgitbank.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.stereotype.Component;

// 스프링의 root-context에 컴포넌트로서 등록할 것
@Component
public class RSP {

	
	// 가위 바위 보 중 하나를 입력 받으면 승/무/패 결과가 리턴되는 메서드를 하나 작성
	
	// JUnit 테스트로 메서드를 20회 테스트하고 파일에 메서드 실행 결과에 대한 로그를 남겨보세요
	public String rsp() {
		
		
	int scissors = 1;
	int rock = 2;
	int paper = 3;
	int choice = 0;
	boolean good = false;
	String result = "결과없음";
	
	Scanner sc = new Scanner(System.in);
	int random = (int)(Math.random() * 3 + 1);
	
	System.out.println(random);
	System.out.println("1.가위 2.바위 3.보");
	
	while(good == false) {
		try {
			choice = sc.nextInt();
			System.out.println(choice);
			
			if(choice < 1 || choice > 3) {
				throw new InputMismatchException("잘못된 값입니다!");
			} else {
				good = true;
			}
			
		} catch (InputMismatchException e) {
			System.out.println("잘못된 값입니다.");
			sc = new Scanner(System.in);
		}
	}
	
	if(choice == scissors) {
		if(random == 1) {
			result = "무승부!";
		} else if (random == 2) {
			result = "패배!";
		} else if (random == 3) {
			result = "승리!";
		}
	}
	
	if(choice == rock) {
		if(random == 2) {
			result = "무승부!";
		} else if (random == 3) {
			result = "패배!";
		} else if (random == 1) {
			result = "승리!";
		}
	}
	
	if(choice == paper) {
		if(random == 3) {
			result = "무승부!";
		} else if (random == 1) {
			result = "패배!";
		} else if (random == 2) {
			result = "승리!";
		}
	}
	
		System.out.println(result);
	
		return result;
	}
	
}
