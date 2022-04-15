package com.khan.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping
	public String welcome() {
		return "Welcome Spring Boot App...";
	}
	
}
