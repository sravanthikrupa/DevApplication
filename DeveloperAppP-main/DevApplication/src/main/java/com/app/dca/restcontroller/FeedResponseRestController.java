package com.app.dca.restcontroller;

import java.time.LocalDateTime;
import java.util.List;

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

import com.app.dca.dto.FeedResponseDTO;
import com.app.dca.entity.FeedResponse;
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
	public FeedResponse addResponse(@RequestBody @Valid FeedResponse resp)
	{
		log.info("inside add Response");
		FeedResponse f = service.addResponse(resp);
		FeedResponseDTO dto = new FeedResponseDTO(f.getRespId(), f.getAnswer(),f.getRespDate(),f.getRespTime(),f.getAccuracy());
		return resp;
	}
	
	@PutMapping("/updateResponse")
	public FeedResponse updateFeedResponse(@RequestBody FeedResponse resp) {
		log.info("inside update responses");
		
		return service.editResponse(resp);
	}
	
	@DeleteMapping("/deleteResponse/{id}")
	public FeedResponse removeFeedResponse(@PathVariable int id) throws UnknownFeedResponseException 
	{
		log.info("inside delete response by id");
		return service.removeResponse(id);
	}
	
	@GetMapping("/getByFeedId/{feedId}")
	public List<FeedResponse> getResponsesByFeed(@PathVariable int feedId) throws UnknownFeedException 
	{
		log.info("inside get list of responses by feedId");
		return service.getResponseByFeed(feedId);
	}
	
	
	@GetMapping("/FeedResponses")
	public List<FeedResponse> getAllFeedResponses()
	{
		log.info("inside get all feedResponses");
		return service.getAllResponses();
	}
	
}//end class