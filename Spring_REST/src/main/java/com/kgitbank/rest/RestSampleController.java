package com.kgitbank.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.model.FruitVO;


import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class RestSampleController {

	@GetMapping(value = "/getstr", produces="text/plain; charset=UTF-8")
	public String getString() {
		return "�ȳ��ϼ��� RESTController�Դϴ�.";
	}
	
	@GetMapping(value="/getstr2", produces=MediaType.TEXT_PLAIN_VALUE)
	public String getString2() {
		return "<h3>Hello Rest!</h3>";
	}
	
	@GetMapping(value="/getstr3", produces=MediaType.TEXT_HTML_VALUE)
	public String getString3() {
		return "<h3>Hello Rest!</h3>";
	}
	
	@GetMapping(value="getSample", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public FruitVO getSampleObject() {
		return new FruitVO();
	}
	
	@GetMapping(value="getSampleXML", produces = MediaType.APPLICATION_XML_VALUE)
	public FruitVO getSampleObject2() {
		return new FruitVO();
	}
	
	@GetMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FruitVO> getSampleList() {
		List<FruitVO> list = new ArrayList<>();
		
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		list.add(new FruitVO());
		
		return list;
	}
	
	
	@GetMapping(value = "/getMap", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, FruitVO> getSampleMap() {
		Map<String, FruitVO> map = new HashMap<>();
		
		map.put("apple1", new FruitVO());
		map.put("apple1", new FruitVO());
		map.put("apple1", new FruitVO());
		
		return map;
	
	}
	
	@GetMapping(value = "/getRespEntity")
	public ResponseEntity<FruitVO> getRespEntity() {
		
		// ResponseEntity�� ���� Http������ �ڼ��� ������ �� �ִ�
		// ������ �޴� ������ status �ڵ带 Ȱ���� �� �ִ� 
		ResponseEntity<FruitVO> result = null;
		
		result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FruitVO());
		
		return result;
	}
	
	@GetMapping(value = "/path/{year}/{month}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String pathTest(
				@PathVariable("year") Integer year, 
				@PathVariable("month") Integer month
			) {
		
		return "Hello! you putted " + year + "/" + month + " in your in path";
		//http://localhost:8080/rest/sample/path/2021/08
		// Hello! you putted 2021/8 in your in path
	}
	
	/*
	 * 	@ RequestBody
	 * 	  - ��Ʈ�ѷ����� JSON �����͸� �޾ƾ� �� �� ����ϴ� ������̼�
	 * 
	 *  @PostMapping�� �޼����� ������ ���
	 *    - ũ���� REST Client
	 */
	
	@PostMapping(value ="/fruit", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public String convertJsonFruit(@RequestBody FruitVO fruit) {
		
		
		return "Your fruit is " + fruit;
	}
	
}


































