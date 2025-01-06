package com.usermanagementapp.springboot.service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.usermanagementapp.springboot.exception.ResourceNotFoundException;

import com.usermanagementapp.springboot.model.User;
import com.usermanagementapp.springboot.dto.UserDto;
import com.usermanagementapp.springboot.mapper.UserMapper;
import com.usermanagementapp.springboot.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	  @Autowired
	  private UserRepository userRepository;
	  
	  // Constructor
	  public UserServiceImpl(UserRepository userRepository) {
		  super();
		  this.userRepository = userRepository;
	  }

	  @Override
	  public UserDto createUser(UserDto userdto) {
		  User user = UserMapper.mapToUser(userdto);
		  User savedUser = userRepository.save(user); // save into database.
		  return UserMapper.mapToUserDto(savedUser);
	  }
	  
	  @Override 
	  public UserDto getUserById(int userId) {
		  User user = userRepository.findById(userId)
		  	.orElseThrow(() -> 
		  		new ResourceNotFoundException("User does not exist with the provided ID : " + userId));
		  
		  return UserMapper.mapToUserDto(user);
	  }
	  
	  @Override 
	  public List<UserDto> getAllUsers() {
		  List<User> users = userRepository.findAll();
		  return users.stream().map((user) -> UserMapper.mapToUserDto(user))
				  .collect(Collectors.toList());  
	  }

	  @Override 
	  public UserDto updateUser(int userId, UserDto updatedUser) {
		  User user = userRepository.findById(userId)
				  	.orElseThrow(() -> 
				  		new ResourceNotFoundException("User does not exist with the provided ID : " + userId));
		  
		  user.setFirstName(updatedUser.getFirstName());
		  user.setLastName(updatedUser.getLastName());
		  user.setEmailId(updatedUser.getEmailId());
		  
		  User updatedUserObj = userRepository.save(user);
		  
		  return UserMapper.mapToUserDto(updatedUserObj);
	  }
	  
	  @Override 
	  public void deleteUser(int userId) {
		@SuppressWarnings("unused")
		User user = userRepository.findById(userId)
				  	.orElseThrow(() -> 
				  		new ResourceNotFoundException("User does not exist with the provided ID : " + userId));
		  
		  userRepository.deleteById(userId);		  
		  		  
	  }
}
