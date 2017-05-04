package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.main.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByLogin(final String login);
}
