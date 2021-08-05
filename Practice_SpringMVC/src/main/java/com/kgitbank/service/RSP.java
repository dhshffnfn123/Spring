package com.kgitbank.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.stereotype.Component;

// �������� root-context�� ������Ʈ�μ� ����� ��
@Component
public class RSP {

	
	// ���� ���� �� �� �ϳ��� �Է� ������ ��/��/�� ����� ���ϵǴ� �޼��带 �ϳ� �ۼ�
	
	// JUnit �׽�Ʈ�� �޼��带 20ȸ �׽�Ʈ�ϰ� ���Ͽ� �޼��� ���� ����� ���� �α׸� ���ܺ�����
	public String rsp() {
		
		
	int scissors = 1;
	int rock = 2;
	int paper = 3;
	int choice = 0;
	boolean good = false;
	String result = "�������";
	
	Scanner sc = new Scanner(System.in);
	int random = (int)(Math.random() * 3 + 1);
	
	System.out.println(random);
	System.out.println("1.���� 2.���� 3.��");
	
	while(good == false) {
		try {
			choice = sc.nextInt();
			System.out.println(choice);
			
			if(choice < 1 || choice > 3) {
				throw new InputMismatchException("�߸��� ���Դϴ�!");
			} else {
				good = true;
			}
			
		} catch (InputMismatchException e) {
			System.out.println("�߸��� ���Դϴ�.");
			sc = new Scanner(System.in);
		}
	}
	
	if(choice == scissors) {
		if(random == 1) {
			result = "���º�!";
		} else if (random == 2) {
			result = "�й�!";
		} else if (random == 3) {
			result = "�¸�!";
		}
	}
	
	if(choice == rock) {
		if(random == 2) {
			result = "���º�!";
		} else if (random == 3) {
			result = "�й�!";
		} else if (random == 1) {
			result = "�¸�!";
		}
	}
	
	if(choice == paper) {
		if(random == 3) {
			result = "���º�!";
		} else if (random == 1) {
			result = "�й�!";
		} else if (random == 2) {
			result = "�¸�!";
		}
	}
	
		System.out.println(result);
	
		return result;
	}
	
}
