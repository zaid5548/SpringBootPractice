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

@SpringBootApplication
public class SpringBootWithH2DatabaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =SpringApplication.run(SpringBootWithH2DatabaseApplication.class, args);
		UserRepository userRepository= applicationContext.getBean(UserRepository.class);
		crateUser(userRepository);
		createUsers(userRepository);
		boolean isUserExist= userRepository.existsById(5);
		System.out.println("user is Exist in dataBase : "+isUserExist);
		Optional<User> user=userRepository.findById(3);
		System.out.println(user);
		Long countUser= userRepository.count();
		System.out.println("User Count : "+countUser);
		//userRepository.deleteById(1);
		//userRepository.deleteAll();
		Iterable<User> users= userRepository.findAll();
		for (User user2 : users) {
			System.out.println(user2);
		}
		System.out.println("End All CRUD Operations");
	}

	private static void createUsers(UserRepository userRepository) {
		User user1=new User();
		user1.setName("Zaid Khan");
		user1.setAge(22);
		user1.setDob(LocalDate.of(1997,Month.APRIL,20));
		
		User user2=new User();
		user2.setName("Ajinkya Rahne");
		user2.setAge(33);
		user2.setDob(LocalDate.of(1989,Month.DECEMBER,9));
		
		User user3=new User();
		user3.setName("Rohit Sharma");
		user3.setAge(28);
		user3.setDob(LocalDate.of(1994,Month.JUNE,23));
		
		List<User> userList=new ArrayList<>();
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		Iterable<User> dbSaveduser=userRepository.saveAll(userList);
		System.out.println("Following users info saved in databse: ");
		for (User user : dbSaveduser) {
			System.out.println(user);
		}
		
	}

	private static void crateUser(UserRepository userRepository) {
		User user=new User();
		user.setName("Zaid Khan");
		user.setAge(22);
		user.setDob(LocalDate.of(1998,Month.APRIL,20));
		User dbUser = userRepository.save(user);
		System.out.println("Following user info saved in databse: ");
		System.out.println(dbUser);
	}

}
