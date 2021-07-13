package com.app.dca.restcontroller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.app.dca.entity.Feed;
import com.app.dca.service.IFeedService;
import com.app.dca.service.IFeedServiceImpl;
import com.app.dca.exception.GlobalExceptionHandler;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;


@Validated
@RestController
@RequestMapping("/api")
public class FeedRestController {
	
	Logger logger = LoggerFactory.getLogger(Feed.class);
	
     
	@Autowired
	private IFeedServiceImpl service;
	
	@PostMapping("/feed")
	public Feed addFeed(@RequestBody @Valid Feed f) {
		logger.info("inside add feed");
		
		 return service.addFeed(f);
	}
	
	@PutMapping("/updatefeed")
	public Feed updateFeed(@RequestBody Feed f){
		
		logger.info("inside update feed ");
		
	return service.editFeed(f);
	}
	
	@GetMapping("/feedId/{id}")
	public Feed getFeed(@PathVariable int id)throws UnknownFeedException{
		logger.info("inside get feed information by id");
		
		return service.getFeed(id);
	}
	
	
	@DeleteMapping("/deletefeed/{id}")
	public Feed removeFeed(@PathVariable int id) throws UnknownFeedException{
		logger.info("inside delete feed");
		
		return service.removeFeed(id);
	}
	
	@GetMapping("/DevelopersFeed/{id}")
	public Optional<List<Feed>> getFeedsByDeveloper(@PathVariable int id) throws UnknownDeveloperException{
		logger.info("inside get feed information by developer");
		return service.getFeedsByDeveloper(id);
	}
	
	@GetMapping("/topic/{topic}")
	public Optional<List<Feed>> getFeedsByTopic(@PathVariable String topic){
		
		logger.info("inside get feed by topic");
		
		return service.getFeedsByTopic(topic);
	}
	
	@GetMapping("/keyword/{keyword}")
	public Optional<List<Feed>> getFeedsByKeyword(@PathVariable String keyword){
		
		logger.info("inside get feed by keyword");
		
		return service.getFeedsByKeyword(keyword);
	}
}
	

	
	