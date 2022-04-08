package com.khan.org.SpringBootExample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("This is Home Page !");
		return "<h2>Home</h2>";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("This is contact Page !");
		return "<h2>contact</h2>";
	}
}
