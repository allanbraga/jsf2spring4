package com.app.main.service;

import com.app.main.entity.User;

public interface UserService {
	
	User findByLogin(String login);

}
