package com.khan.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.org.model.WelcomeMessage;

@RestController
public class MyController {

	@Autowired
	private WelcomeMessage message;
	
	@GetMapping(path = "/welcome")
	public String welcome() {
		return message.getMessage();
	}
	
}
