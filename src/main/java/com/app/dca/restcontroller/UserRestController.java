package com.app.dca.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dca.dto.UserDTO;
import com.app.dca.entity.Admin;
import com.app.dca.entity.Developer;
import com.app.dca.entity.User;
import com.app.dca.exception.InvalidLoginException;
import com.app.dca.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/users")
@Api(value = "OAM - User")
public class UserRestController {

	@Autowired
	IUserService userService;
	Logger logger = Logger.getLogger(UserRestController.class.getName());

	@GetMapping("/showAll")
	@ApiOperation(value = "Show All Users using Get Mapping", response = User.class)
	public ResponseEntity<List<UserDTO>> showAllUsers() {

		logger.info("Show All Users Called in User Controller");
		List<User> userList = this.userService.showAllUsers();
		List<UserDTO> userDtoList = new ArrayList<>();

		for (User user : userList) {

			UserDTO userDto = new UserDTO();
			userDto.setUserId(user.getUserId());
			userDto.setUserType(user.getUserType());

			if (userDto.getUserType().equals("developer")) {
				Developer developer = (Developer) user;
				userDto.setUserName(developer.getName());
			} else if (userDto.getUserType().equals("admin")) {
				Admin admin = (Admin) user;
				userDto.setUserName(admin.getAdminName());
			}
			userDtoList.add(userDto);
		}

		return new ResponseEntity<>(userDtoList, HttpStatus.OK);
	}

	@PostMapping("/login")
	@ApiOperation(value = "Login using Post Mapping", response = User.class)
	public ResponseEntity<UserDTO> login(@RequestBody @Valid User user) throws InvalidLoginException {

		logger.info("Login called in User Controller");
		User loggedInUser = this.userService.login(user);
		UserDTO userDto = new UserDTO();
		userDto.setUserId(loggedInUser.getUserId());
		userDto.setUserType(loggedInUser.getUserType());

		if (userDto.getUserType().equals("developer")) {
			Developer developer = (Developer) loggedInUser;
			userDto.setUserName(developer.getName());
		} else if (userDto.getUserType().equals("admin")) {
			Admin admin = (Admin) loggedInUser;
			userDto.setUserName(admin.getAdminName());
		}

		return new ResponseEntity<>(userDto, HttpStatus.OK);

	}

	@GetMapping("/logout")
	@ApiOperation(value = "Logout using Get Mapping", response = User.class)
	public ResponseEntity<User> logout() {

		logger.info("Logout called in User Controller");
		User loggedOutUser = this.userService.logout();

		return new ResponseEntity<>(loggedOutUser, HttpStatus.RESET_CONTENT);

	}
}