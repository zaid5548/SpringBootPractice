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
import com.khan.org.exception.UserDataAccessException;

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
		if (findById.isPresent()) {
			User user = findById.get();
			user.setAge(newAge);
			userRepository.save(user);
		} else {
			throw new UserDataAccessException("User With ID =" + id + " Not found in database");
		}
	}

	public void createUsers(Iterable<User> users) {
		Iterable<User> dbSaveduser = getUserRepository().saveAll(users);
		System.out.println("Following users info saved in databse: ");
		for (User user : dbSaveduser) {
			System.out.println(user);
		}

	}

	public User crateUser(User user) {
		User dbUser = getUserRepository().save(user);
		return dbUser;
	}

	public Optional<User> findUserById(Integer id) throws UserDataAccessException {
		return getUserRepository().findById(id);
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

	public void deleteById(Integer id) throws UserDataAccessException {
		System.out.println("Deleted Entity by Id : " + id);
		if (id == null)
			throw new UserDataAccessException("User Id can't be nul");
		Optional<User> findById = getUserRepository().findById(id);
		if (findById.isPresent())
			getUserRepository().deleteById(id);
		else
			throw new UserDataAccessException("User With ID =" + id + " Not found in database");

	}

}
