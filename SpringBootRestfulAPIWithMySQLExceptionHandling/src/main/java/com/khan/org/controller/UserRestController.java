package com.khan.org.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.khan.org.entity.User;
import com.khan.org.exception.UserDataAccessException;
import com.khan.org.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	// CRUD

	// @RequestMapping(path = "user/create",method = RequestMethod.POST)
	@PostMapping(path = "user/create")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		user= userService.crateUser(user);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping(path = "multipleUsers/create")
	public void createUsers(@RequestBody Iterable<User> users) {
		userService.createUsers(users);
	}

	@RequestMapping(path = "id/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws UserDataAccessException {
		User user=userService.findUserById(id).orElseThrow(()->new UserDataAccessException("User Not Fount with = "+id));
		return ResponseEntity.ok().body(user);
	}

	@GetMapping(path = "/allusers")
	public Iterable<User> getAllUsers() {
		return userService.findAllUser();
	}

	@PutMapping(path = "id/{id}/newAge/{newAge}")
	public void updateUserById(@PathVariable("id") Integer id, @PathVariable("newAge") Integer newAge)
			throws UserDataAccessException {
		userService.updateUserAgeById(id, newAge);
	}

	@DeleteMapping(path = "delete/id/{id}")
	public void deleteUserById(@PathVariable("id") Integer id) throws UserDataAccessException {
		userService.deleteById(id);
	}
	
}
