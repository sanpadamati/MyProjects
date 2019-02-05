package com.bootdatahiding.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootdatahiding.model.user.User;

public interface UserRepo extends JpaRepository<User, Integer>{
		
}
