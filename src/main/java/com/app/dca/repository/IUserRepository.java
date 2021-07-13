package com.app.dca.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.dca.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
	
}
