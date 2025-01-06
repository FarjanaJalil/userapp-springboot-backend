package com.usermanagementapp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagementapp.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
