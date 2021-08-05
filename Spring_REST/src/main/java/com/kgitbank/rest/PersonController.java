package com.kgitbank.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/ajax")
public class PersonController {
	
	@RequestMapping(value = {"/person_home"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String crud(Model model) {
		log.info("Person Controller¿¡ µµÂø");
		
		return "/person";
	}
	
}
