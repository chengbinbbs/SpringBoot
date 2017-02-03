package com.daysluck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daysluck.domain.User;
import com.daysluck.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/add")
	public Integer addUser(@RequestParam("name")String name,@RequestParam("age")Integer age){
		return userService.create(name, age);
	}
	
	@GetMapping("/user/list/{age}")
	public List<User> getAllUsers(@PathVariable Integer age){
		return userService.getAllUsers(age);
	}
	
	@DeleteMapping("/user/delete/{name}")
	public Integer deleteByName(@PathVariable String name){
		return userService.deleteByName(name);
	}
}
