package com.kgitbank.rest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
					 "file:src/main/webapp/WEB-INF/spring/root-context.xml",
					 "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
					 })
@WebAppConfiguration
public class ControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void testSetup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build(); // web.xml�� �ҷ��ٰ� ��¥ context�� ����� ����Ѵ�
	}

	@Test
	public void homeTest() throws Exception {
		
		// mockMvc : �׽�Ʈ�� �����ϱ� ���� ������ Spring MVC
		// perform(requestBuilders) : ������ mockMvc�� ��û�� �������� �޼���
		// MockMvcRequestBuilders : RequestBuider�� �����ϴ� ���丮 Ŭ����
		// andReturn() : perform()�� ������� ���� ���� ������. �ش� ��Ʈ�ѷ� ���� ������� ���ϴ� ���鿡 ������ �� �ִ�
		
		String resultPage = mockMvc
							.perform(MockMvcRequestBuilders.get("/normal/home"))
							.andReturn().getModelAndView().getViewName();
		
		assertEquals("/home", resultPage);
	}
	
	@Test
	public void homeModelTest() throws Exception {
		
		Map<String, Object> attributes = mockMvc
							.perform(MockMvcRequestBuilders.get("/normal/home"))
							.andReturn().getModelAndView().getModel();
		
		assertEquals("ABC", attributes.get("string"));
		assertEquals(123, attributes.get("integer"));
		assertEquals(123.1234, attributes.get("double"));
		assertEquals("�����Ƹ�", attributes.get("flavor"));
		
	}
	
	@Test
	public void restTest() throws Exception {
		ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/sample/getMap"));
		
		action.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
	}


}























