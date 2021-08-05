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
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build(); // web.xml을 불러다가 가짜 context를 만들어 사용한다
	}

	@Test
	public void homeTest() throws Exception {
		
		// mockMvc : 테스트를 진행하기 위해 생성한 Spring MVC
		// perform(requestBuilders) : 생성한 mockMvc에 요청을 보내보는 메서드
		// MockMvcRequestBuilders : RequestBuider를 생성하는 팩토리 클래스
		// andReturn() : perform()의 결과에서 리턴 값을 꺼낸다. 해당 컨트롤러 실행 결과에서 원하는 값들에 접근할 수 있다
		
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
		assertEquals("복숭아맛", attributes.get("flavor"));
		
	}
	
	@Test
	public void restTest() throws Exception {
		ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/sample/getMap"));
		
		action.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
	}


}























