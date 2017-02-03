package com.daysluck.service;

import java.util.List;

import com.daysluck.domain.User;

public interface UserService {

	int create(String name,Integer age);
	
	int deleteByName(String name);
	
	List<User> getAllUsers(Integer age);
}
