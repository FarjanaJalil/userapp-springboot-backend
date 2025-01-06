package com.usermanagementapp.springboot.mapper;

import com.usermanagementapp.springboot.dto.UserDto;
import com.usermanagementapp.springboot.model.User;

public class UserMapper {
	public static UserDto mapToUserDto (User user) {
		return new UserDto (
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmailId()
		);
	}
	
	public static User mapToUser (UserDto userdto) {
		return new User (
				userdto.getId(),
				userdto.getFirstName(),
				userdto.getLastName(),
				userdto.getEmailId()
		);
	}	
}
