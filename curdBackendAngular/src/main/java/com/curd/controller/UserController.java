package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curd.entities.User;
import com.curd.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController
{
	@Autowired
	private UserRepository userRepository;
	
	/*To fetch all users*/
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}	
	
	/*To fetch particular user*/
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id)
	{
		return userRepository.findOne(id);
	}
	/*To delete particular user*/
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id)
	{
		userRepository.delete(id);
		return true;
	}

	/*To edit particular user*/
	@PutMapping("/user")
	public User updateUser(@RequestBody User user)
	{
		return userRepository.save(user);
	}
	
	/*To create  user*/
	@PostMapping("/user")
	public User createUser(@RequestBody User user)
	{
		return userRepository.save(user);
	}
}
