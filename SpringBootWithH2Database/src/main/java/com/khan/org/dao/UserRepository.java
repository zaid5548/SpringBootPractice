package com.khan.org.dao;

import org.springframework.data.repository.CrudRepository;

import com.khan.org.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}
