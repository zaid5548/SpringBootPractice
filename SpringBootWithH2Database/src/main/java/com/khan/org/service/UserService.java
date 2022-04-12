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

	public void updateUserAgeById(Integer id, Integer newAge) throws UserDataAccessException {
		System.out.println("Updating Entity by Id = " + id);
		if (id == null)
			throw new UserDataAccessException("User Id can't be null");
		else if (newAge == null)
			throw new UserDataAccessException("User Age can't be null");
		Optional<User> findById = getUserRepository().findById(id);
		if(findById.isPresent()) {	
			User user = findById.get();
			user.setAge(newAge);
			userRepository.save(user);
		}else {
			throw new UserDataAccessException("User With ID =" + id + " Not found in database");
		}
	}

	public void createUsers() {
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

		Iterable<User> dbSaveduser = getUserRepository().saveAll(userList);
		System.out.println("Following users info saved in databse: ");
		for (User user : dbSaveduser) {
			System.out.println(user);
		}

	}

	public void crateUser() {
		User user = new User();
		user.setName("Zaid Khan");
		user.setAge(22);
		user.setDob(LocalDate.of(1998, Month.APRIL, 20));
		User dbUser = getUserRepository().save(user);
		System.out.println("Following user info saved in databse: ");
		System.out.println(dbUser);
	}

	public User findUserById(Integer id) throws UserDataAccessException {
		System.out.println("Finding Entity by Id : " + id);
		if (id == null)
			throw new UserDataAccessException("User Id can't be null");

		Optional<User> findById = getUserRepository().findById(id);
		if (findById.isPresent())
			return findById.get();
		throw new UserDataAccessException("User With ID =" + id + " Not found in database");
	}

	public Iterable<User> findAllUser() {
		return getUserRepository().findAll();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
