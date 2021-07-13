package com.app.dca.service;

import java.util.List;

import com.app.dca.entity.User;
import com.app.dca.exception.InvalidLoginException;

public interface IUserService {

	public List<User> showAllUsers();
	
	public User login(User user) throws InvalidLoginException;
	
	public User logout();

}
