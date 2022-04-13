package com.khan.org.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.khan.org.entity.User;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Integer> {

}
