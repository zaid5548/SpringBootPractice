package com.khan.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.khan.dao.UserRepository;
import com.khan.model.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		User user = new User();
		user.setName("Zaid khan");
		user.setCity("Ghaizabad");
		user.setStatus("Imam a Java Developer");
		User user1=userRepository.save(user);
		
		System.out.println(user1);
	}

}
