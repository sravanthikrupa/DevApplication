package com.app.dca.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.UserD;
import com.app.dca.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository repu;



	@Override
	public UserD login(UserD user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserD logout(UserD user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
