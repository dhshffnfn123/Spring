package com.kgitbank.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.model.PersonVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/work")
public class PersonController {
	
	@RequestMapping(value = {"getSelect"}, produces=MediaType.TEXT_HTML_VALUE)
	public PersonVO crud() {
		
		
		return new PersonVO();
	}
	
}
