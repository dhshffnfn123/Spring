package com.kgitbank.rest.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ajax")
@Controller
public class AjaxController {

	@GetMapping("/")
	public String home() {
		return "/ajax/home";
	}
}
