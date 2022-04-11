package com.khan.org.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Value("${my.college.name}")
	private String myCollegeName;
	
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public String welcome() {
		return "<h1>Welcome To Application Properties Spring Boot Project</h1>"+myCollegeName;
	}
	
}
