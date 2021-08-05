package com.kgitbank.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/normal")
public class NormalController {

	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute(123);
		model.addAttribute("ABC");
		model.addAttribute(123.1234);
		model.addAttribute("flavor", "º¹¼þ¾Æ¸À");
		
		return "/home";
	}
}
