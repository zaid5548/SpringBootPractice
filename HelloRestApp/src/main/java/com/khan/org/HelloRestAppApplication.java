package com.khan.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.khan.controller"})
public class HelloRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloRestAppApplication.class, args);
	}

}
