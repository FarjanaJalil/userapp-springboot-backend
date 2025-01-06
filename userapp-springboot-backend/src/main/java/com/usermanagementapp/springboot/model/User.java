package com.usermanagementapp.springboot.model;

import jakarta.persistence.*;

// Make the 'User' JAVA class a JPA entity
@Entity
@Table(name = "users")
public class User {

	// Primary key
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increments
	@Column
	private int id;	

	@Column(name="first_name") 
	private String firstName;
	
	@Column(name="last_name") 
	private String lastName;
	
	@Column(name="email_id", nullable=false, unique=true) 
	private String emailId;
	
	// Default constructor
	public User() {
		
	}
	
	// Parameter constructor
	public User(int id, String firstName, String lastName, String emailId) {
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
