package com.usermanagementapp.springboot.dto;

// Handles data transfer between client and server
public class UserDto {
	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	// Default constructor
	public UserDto() {
		
	}
	
	// Parameter constructor
	public UserDto(int id, String firstName, String lastName, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	// Getter and setter methods 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
