package com.daysluck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.daysluck.domain.User;
import com.daysluck.service.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/{name}")
	public List<User> findByName(@PathVariable String name){
		return userRepository.findByName(name);
	}
	
	
	@GetMapping("/user/list/{age}")
	public List<User> findUsers(@PathVariable Integer age){
		return userRepository.findUsers(age);
	}
	
	@GetMapping("/user/find/{name}")
	public List<User> findName(@PathVariable String name){
		return userRepository.findUserName(name);
	}
}
