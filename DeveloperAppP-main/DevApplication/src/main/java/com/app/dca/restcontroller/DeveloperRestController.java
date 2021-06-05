package com.app.dca.restcontroller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

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

import com.app.dca.dto.DeveloperDTO;
import com.app.dca.entity.Developer;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.service.IDeveloperService;
import com.app.dca.service.IDeveloperServiceImpl;

@Validated
@RestController
@RequestMapping("/api")
public class DeveloperRestController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(DeveloperRestController.class);
	@Autowired
	private IDeveloperServiceImpl service;
	
	public DeveloperRestController() {
		log.info("DeveloperRestController -- constructor ");
		System.out.println(" ----->> Product Rest Controller Constructor ");
	}
	
	@GetMapping("/devhome")
	public String homeRequest()
	{
		return "Welcome : My Developer Application "+LocalDateTime.now();
	}
	
	@PostMapping("/developer")
	public Developer insertDeveloper(@RequestBody @Valid Developer dev)
	{
		log.info("inside insert developers");
		System.out.println("Developer"+dev);
		service.addDeveloper(dev);
		return dev;
	}
	
	@PutMapping("/editdeveloper/{dev}")
	public Developer editDeveloper(@RequestBody Developer dev)
	{
		log.info("inside edit developer");
		service.editDeveloper(dev);
		return dev;
	}
	
	@GetMapping("/getdeveloper/{devId}")
	public Developer getDeveloper(@PathVariable int devId) throws UnknownDeveloperException
	{

		log.info("inside get developer information by id");
		return service.getDeveloper(devId);
	}
	
	@GetMapping("/developers")
	public List<Developer> getAllDevelopers()
	{
		log.info("inside get all developers information");
		return service.getAllDevelopers();
	}
	
	@PutMapping("updateStatus/{devId}")
	public Developer statusUpdate(@RequestBody Developer dev, int id) {
		log.info("inside status update developers information");
		return service.statusUpdate(dev, id);
	}
}
