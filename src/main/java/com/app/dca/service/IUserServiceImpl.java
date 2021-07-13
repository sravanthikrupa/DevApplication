package com.app.dca.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.User;
import com.app.dca.exception.InvalidLoginException;
import com.app.dca.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService {

	Logger logger = Logger.getLogger(IUserServiceImpl.class.getName());

	@Autowired
	IUserRepository repository;

	public IUserServiceImpl(IUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> showAllUsers() {

		List<User> userlist = null;
		try {
			userlist = repository.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return userlist;
	}

	@Override
	public User login(User user) throws InvalidLoginException {

		Optional<User> optional = repository.findById(user.getUserId());
		User loggedInUser = null;
		if (optional.isPresent()) {
			if (optional.get().getPassword().equals(user.getPassword())) {
				loggedInUser = optional.get();
			} else {
				throw new InvalidLoginException("Password does not match!");
			}
		} else {
			throw new InvalidLoginException("User not found!");
		}
		return loggedInUser;

	}

	@Override
	public User logout() {

		return null;

	}

}

