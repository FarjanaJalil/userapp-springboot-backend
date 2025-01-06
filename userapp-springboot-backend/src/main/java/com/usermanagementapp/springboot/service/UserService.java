package com.usermanagementapp.springboot.service;

import java.util.List;

//import com.usermanagementapp.springboot.model.User;
import com.usermanagementapp.springboot.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userdto);
	
	UserDto getUserById(int userId);

	List<UserDto> getAllUsers();

	UserDto updateUser(int userId, UserDto updatedUser);
	
	void deleteUser(int userId);
}
