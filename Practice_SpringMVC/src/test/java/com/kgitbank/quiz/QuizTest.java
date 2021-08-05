package com.kgitbank.quiz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class QuizTest {

	@Autowired
	Prime prime;
	
	// assert���� ���н� ������ �޼����� ���� �� �ִ�
	@Test
	public void check1() {
		System.out.println(prime);
		assertFalse("1�� �Ҽ��� �ƴ϶�� ���;���", prime.isPrime(1)); // 1�� �Ҽ��� �ƴ϶�� �Ǻ��Ǹ� ����ϴ� �׽�Ʈ : ���
	}
	
	@Test
	@Ignore
	public void check3() {
		assertTrue("3�� �Ҽ���� ���;� ��", prime.isPrime(3)); // 3�� �Ҽ���� �Ǻ��Ǹ� ����ϴ� �׽�Ʈ : ����
	}
	
	// ���ϴ� ���ܰ� �߻��ؾ� ����ϴ� �׽�Ʈ
	@Test(expected=ClassNotFoundException.class) // expected : classnotfoundexception�� ������ ���
	public void expectedTest() throws ClassNotFoundException {
		prime.veryAwesomeFunction(123);
	}
	
	
	// �ð����� �ȿ� �����ؾ� �ϴ� �׽�Ʈ
	@Test(timeout = 100)
	public void timeoutTest() {
		for (int i = 0; i < 1000000; ++i) {
			System.out.println(i + "��° ���");
		}
	}
}













