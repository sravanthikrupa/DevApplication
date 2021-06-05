package com.app.dca.restcontroller;


import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dca.entity.UserD;
import com.app.dca.service.IUserService;
import com.app.dca.service.IUserServiceImpl;

import io.swagger.annotations.Api;
@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Developer application")
	public class UserRestController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(UserD.class);
	
	@Autowired
	private IUserServiceImpl service;
	
	public UserRestController() {
		log.info("UserRestController -- constructor ");
		System.out.println("---->> User Rest constructor");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Developer Community Application" + LocalDateTime.now();
	}
	
	

}