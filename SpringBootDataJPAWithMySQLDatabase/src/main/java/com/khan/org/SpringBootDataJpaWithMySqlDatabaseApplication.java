package com.khan.org;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.khan.org.entity.User;
import com.khan.org.service.UserDataAccessException;
import com.khan.org.service.UserService;

@SpringBootApplication
public class SpringBootDataJpaWithMySqlDatabaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(SpringBootDataJpaWithMySqlDatabaseApplication.class, args);
		UserService userService = applicationContext.getBean(UserService.class);
		userService.crateUser(getUser());
		userService.createUsers(getUsers());
		try {
			userService.updateUserAgeById(1, 12);
		} catch (UserDataAccessException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		try {
			userService.deleteById(1);
		} catch (UserDataAccessException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());;
		}
		// userRepository.deleteAll();
		try {
			User user = userService.findUserById(2);
			System.out.println("Fetched User Details by given Id : "+user);
		} catch (UserDataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		userService.findAllUser().forEach(System.out::println);
		System.out.println("End All CRUD Operations");
	}

	private static List<User> getUsers() {
		User user1 = new User();
		user1.setName("Zaid Khan");
		user1.setAge(22);
		user1.setDob(LocalDate.of(1997, Month.APRIL, 20));

		User user2 = new User();
		user2.setName("Ajinkya Rahne");
		user2.setAge(33);
		user2.setDob(LocalDate.of(1989, Month.DECEMBER, 9));

		User user3 = new User();
		user3.setName("Rohit Sharma");
		user3.setAge(28);
		user3.setDob(LocalDate.of(1994, Month.JUNE, 23));

		List<User> userList = new ArrayList<>();

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		return userList;
	}

	private static User getUser() {
		User user = new User();
		user.setName("Zaid Khan");
		user.setAge(22);
		user.setDob(LocalDate.of(1998, Month.APRIL, 20));
		return user;
	}

}
