package com.khan.org.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.org.dao.UserRepository;
import com.khan.org.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void updateUserAgeById(int id,int newAge) {
		System.out.println("Finding Entiti by Id = "+id);
		Optional<User> findById=getUserRepository().findById(id);
		User user=findById.get();
		user.setAge(newAge);
		userRepository.save(user);
	}
	
	public void createUsers() {
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
		
		Iterable<User> dbSaveduser=getUserRepository().saveAll(userList);
		System.out.println("Following users info saved in databse: ");
		for (User user : dbSaveduser) {
			System.out.println(user);
		}
		
	}

	public void crateUser() {
		User user=new User();
		user.setName("Zaid Khan");
		user.setAge(22);
		user.setDob(LocalDate.of(1998,Month.APRIL,20));
		User dbUser = getUserRepository().save(user);
		System.out.println("Following user info saved in databse: ");
		System.out.println(dbUser);
	}

	public Optional<User> findUserById(int id) {
		return getUserRepository().findById(id);
	}
	
	public Iterable<User> findAllUser(){
		return getUserRepository().findAll();
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
}
