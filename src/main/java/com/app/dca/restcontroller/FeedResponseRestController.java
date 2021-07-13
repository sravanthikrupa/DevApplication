package com.app.dca.restcontroller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.dca.entity.Feedresponse;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.exception.UnknownFeedResponseException;
import com.app.dca.service.IFeedResponseService;
import com.app.dca.service.IFeedResponseServiceImpl;

import io.swagger.annotations.Api;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Developer Community App")
public class FeedResponseRestController {
	
	Logger log = (Logger) org.slf4j.LoggerFactory.getLogger(FeedResponseRestController.class);
	@Autowired
    IFeedResponseServiceImpl service;
	
	public FeedResponseRestController() {
		log.info("FeedResponseRestController ------- controller ");
		System.out.println("--------Response Rest Controller Constructor----------");
	}
	

	
	@PostMapping("/response")
	public Feedresponse addResponse(@RequestBody @Valid Feedresponse resp)
	{
		log.info("inside add Response");
		Feedresponse f = service.addResponse(resp);
		//FeedResponseDTO dto = new FeedResponseDTO(f.getRespId(), f.getAnswer(),f.getRespDate(),f.getRespTime(),f.getAccuracy());
		return resp;
	}
	
	@PutMapping("/updateResponse")
	public Feedresponse updateFeedResponse(@RequestBody Feedresponse resp) {
		log.info("inside update responses");
		
		return service.editResponse(resp);
	}
	
	@DeleteMapping("/deleteResponse/{id}")
	public Feedresponse removeFeedResponse(@PathVariable int id) throws UnknownFeedResponseException 
	{
		log.info("inside delete response by id");
		return service.removeResponse(id);
	}
	
	@GetMapping("/getByFeedId/{feedId}")
	public Optional<List<Feedresponse>> getResponsesByFeed(@PathVariable int feedId) throws UnknownFeedException 
	{
		log.info("inside get list of responses by feedId");
		return service.getResponseByFeed(feedId);
	}
	
	@GetMapping("/getByDeveloperId/{devId}")
	public Optional<List<Feedresponse>> getResponsesByDeveloper(@PathVariable int devId) throws UnknownDeveloperException 
	{
		log.info("inside get list of responses by devId");
		return service.getResponseByDeveloper(devId);
	}
	
	
	@GetMapping("/FeedResponses")
	public List<Feedresponse> getAllFeedResponses()
	{
		log.info("inside get all feedResponses");
		return service.getAllResponses();
	}
	
}//end class