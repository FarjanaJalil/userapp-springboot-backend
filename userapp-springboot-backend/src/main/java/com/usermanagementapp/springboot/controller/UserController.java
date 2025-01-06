package com.usermanagementapp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.usermanagementapp.springboot.dto.UserDto;
import com.usermanagementapp.springboot.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// Constructor
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// Handler methods - handle CRUD operations
	
	// Build Create User REST API
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto) {
		UserDto savedUser = userService.createUser(userdto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);		
	}
	
	// Build Get User By Id REST API
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") int userId) {
		UserDto userDto = userService.getUserById(userId);
		return ResponseEntity.ok(userDto);
	}
	
	// Build Get All User REST API
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	// Build Update User REST API
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") int userId, @RequestBody UserDto updatedUser) {
		UserDto userDto = userService.updateUser(userId, updatedUser);
		return ResponseEntity.ok(userDto);
	}
	
	// Build Delete User REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok("User deleted successfully.");
	}
		
}
