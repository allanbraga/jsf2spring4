package com.app.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.main.entity.User;
import com.app.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByLogin(String login) {
		return this.userRepository.findByLogin(login);
	}	

}
