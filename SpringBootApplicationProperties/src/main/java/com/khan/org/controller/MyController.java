package com.khan.org.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping(path = "/",method = RequestMethod.GET)
	public String welcome() {
		return "<h1>Welcome To Application Properties Spring Boot Project</h1>";
	}
	
}
