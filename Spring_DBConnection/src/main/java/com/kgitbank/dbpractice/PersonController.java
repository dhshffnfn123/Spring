package com.kgitbank.dbpractice;




import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kgitbank.mapper.PersonMapper;
import com.kgitbank.model.Employee;
import com.kgitbank.model.Person;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;
import oracle.net.aso.h;


@Log4j
@Controller
@RequestMapping("/dbconn")
public class PersonController {
	
	@Autowired
	ServletContext application;
	@Autowired
	HttpSession session;
	@Autowired
	PersonMapper personMapper;
	
	
	@RequestMapping(value = {"/CRUD"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String crud(Model model) {
		log.info("CRUD Controller¿¡ µµÂø");
		
		return "/CRUD";
	}
	
	
	
	@RequestMapping(value = {"/select"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String select(Model model) {
		log.info("select Controller¿¡ µµÂø");
		
		List<Person> people = personMapper.select();
			
		for(Person person : people) {
				System.out.println(person.toString());
		}
			
		model.addAttribute("person", people);
			
		return "/dbconn/select";
	}
	
	
	
	@GetMapping("/insert")
	public String getInsert (Person person) {
		
		return "/dbconn/insert";
	}
	
	@PostMapping("/insert")
	public String postInsert(Person person) {
		
		
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getAddress());
		
		personMapper.insert(person);
		
		
		
		return "/dbconn/insert";
	}
	
	@GetMapping("/delete")
	public String getDelete(Person person) {
		
		return "/dbconn/delete";
	}
	
	@PostMapping("/delete")
	public String postDelete(Person person) {
		
		personMapper.delete(person.getName());
		
		return "/dbconn/delete";
	}
	
}





























