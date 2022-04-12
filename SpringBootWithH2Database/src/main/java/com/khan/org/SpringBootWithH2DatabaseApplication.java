package com.khan.org;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.khan.org.dao.UserRepository;
import com.khan.org.entity.User;
import com.khan.org.service.UserDataAccessException;
import com.khan.org.service.UserService;

@SpringBootApplication
public class SpringBootWithH2DatabaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(SpringBootWithH2DatabaseApplication.class, args);
		UserService userService = applicationContext.getBean(UserService.class);
		userService.crateUser();
		userService.createUsers();
		try {
			userService.updateUserAgeById(1, 12);
		} catch (UserDataAccessException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		// userRepository.deleteById(1);
		// userRepository.deleteAll();
		User user;
		try {
			user = userService.findUserById(2);
			System.out.println("Fetched User Details by given Id : "+user);
		} catch (UserDataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		userService.findAllUser().forEach(System.out::println);
		System.out.println("End All CRUD Operations");
	}
}
