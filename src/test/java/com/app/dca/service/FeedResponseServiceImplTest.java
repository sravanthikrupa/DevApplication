package com.app.dca.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.exception.UnknownFeedResponseException;
import com.app.dca.entity.Developer;
import com.app.dca.entity.Feed;
import com.app.dca.entity.Feedresponse;
import com.app.dca.repository.DeveloperRepository;
import com.app.dca.repository.FeedRepository;
import com.app.dca.repository.FeedResponseRepository;
import com.app.dca.repository.IDeveloperRepository;
import com.app.dca.service.IDeveloperServiceImpl;
import com.app.dca.service.IFeedResponseServiceImpl;

import org.junit.jupiter.api.Test;

class FeedResponseServiceImplTest {
	FeedResponseRepository  feedResRepo;
	FeedRepository feedRepo;
	private static IFeedResponseServiceImpl feedRespService;
	private static IFeedServiceImpl feedService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
		
		feedResRepo = mock(FeedResponseRepository.class); // test through approach 2
		feedRespService = new  IFeedResponseServiceImpl(feedResRepo); 	// Approach 2
		feedRepo = mock(FeedRepository.class);
		feedService = new IFeedServiceImpl(feedRepo);
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	Developer d = new Developer(3, "abc", "abc@gmail.com", "Medium",LocalDate.of(2020, 05, 29),null,2,11,false,true);
	Feed f = new Feed(10,"what is JDBC",LocalDate.of(2021,03,25), LocalTime.of(4, 23, 12),"JDBC",10,d,1);
	
	@Test
    //@Disabled
	@DisplayName("Test-Save feedResponse")
	void testSaveFeedResponse() {
		Feedresponse input = new Feedresponse(30,"it's match", LocalDate.of(31, 05, 21), LocalTime.of(4, 23, 12),1,d,f);
		Feedresponse savedFeedResponse = new Feedresponse(30,"it's match", LocalDate.of(31, 05, 21), LocalTime.of(4, 23, 12),1,d,f);
	
		when(feedResRepo.save(input)).thenReturn(savedFeedResponse);
		feedRespService.addResponse(input);
		verify(feedResRepo).save(input);
		
	}
	
	
	
	@Test
	//@Disabled
	@DisplayName("Test-delete FeedResponse")
	void testDeleteFeedResponse() throws UnknownFeedResponseException {
		
		Feedresponse input = new Feedresponse(30,"thats good", LocalDate.of(25, 06, 20), LocalTime.of(4, 23, 12),1,d,f);
		Feedresponse savedFeedResponse = new Feedresponse(30,"thats good", LocalDate.of(25, 06, 20), LocalTime.of(4, 23, 12),1,d,f);
		
		when(feedResRepo.findById(input.getRespId())).thenReturn(Optional.of(savedFeedResponse));
		feedRespService.removeResponse(input.getRespId());
		verify(feedResRepo).deleteById(input.getRespId());
		assertEquals(input, savedFeedResponse);
		
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Get Response by Developer")
	void testgetResponsebyDeveloper() throws UnknownFeedResponseException, UnknownDeveloperException{
		
		
		int input = 1;
		Feedresponse feedresponse = mock(Feedresponse.class);
		Optional<List<Feedresponse>> optionalFeedResponse = Optional.empty();
		when(feedResRepo.getResponseByDeveloper(input)).thenReturn(optionalFeedResponse);
		Executable executable = ()->feedRespService.getResponseByDeveloper(input);
		assertThrows(UnknownDeveloperException.class, executable);
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Get Response by Feed")
	void testgetResponsebyFeed() throws UnknownFeedResponseException, UnknownFeedException{
		
		
		int input = 1;
		Feedresponse feedResponse = mock(Feedresponse.class);
		Optional<List<Feedresponse>> optionalFeed = Optional.empty();
		
		when(feedResRepo.getResponseByFeed(input)).thenReturn(optionalFeed);
		Executable executable = ()->feedRespService.getResponseByFeed(input);
		assertThrows(UnknownFeedException.class, executable);
		
	}
	
	
	@Test
	//@Disabled
	@DisplayName("Test-edit FeedResponse")
	void testeditFeedResponse() throws UnknownFeedException {
		Feedresponse input = new Feedresponse(30,"thats good", LocalDate.of(25, 06, 20), LocalTime.of(4, 23, 12),1,d,f);
		Feedresponse savedFeedResponse = new Feedresponse(30,"thats good", LocalDate.of(25, 06, 20), LocalTime.of(4, 23, 12),1,d,f);
	
		when(feedResRepo.save(input)).thenReturn(savedFeedResponse);
		feedRespService.editResponse(input);
		verify(feedResRepo).save(input);
		
	}
	

	
	
	@Test
	//@Disabled
	@DisplayName("Test-Get All FeedResponses")
	void testGetAllFeedResponses() {
		
		
		List<Feedresponse> feedList = mock(List.class); 
		//when() and 	//thenReturn()
		when(feedResRepo.findAll()).thenReturn(feedList);
		//call the actual method 
		feedRespService.getAllResponses();
		verify(feedResRepo).findAll();
		
	}
	
	
	
	@Test
	//@Disabled
	@DisplayName("Test-like FeedResponse")
	void testLikeFeedResponse() {
		
		Feedresponse input = new Feedresponse(30,"thats good", LocalDate.of(25, 06, 20), LocalTime.of(4, 23, 12),1,d,f);
		Feedresponse savedFeedResponse = new Feedresponse(30,"thats good", LocalDate.of(25, 06, 20), LocalTime.of(4, 23, 12),1,d,f);
		
		when(feedResRepo.findById(input.getRespId())).thenReturn(Optional.of(savedFeedResponse));
		feedRespService.likeResponse(input.getRespId());
		verify(feedResRepo).findById(input.getRespId());
		
		
	}
	
	
	
}