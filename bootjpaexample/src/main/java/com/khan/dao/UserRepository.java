package com.khan.dao;

import org.springframework.data.repository.CrudRepository;

import com.khan.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
}
