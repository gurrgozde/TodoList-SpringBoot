package com.deneme.deneme.controllers;
import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deneme.deneme.services.*;
import com.deneme.deneme.enti.User;


@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userservices;
	public UserController(UserService userservices) {
		this.userservices=userservices;
	}
	@GetMapping
	public List<User> getAllUsers(){
		return userservices.getAllUsers();
	}
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userservices.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return userservices.getOneUserById(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userservices.updateOneUser(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userservices.deleteById(userId);
	}
}
