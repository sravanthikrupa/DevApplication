package com.app.dca.service;

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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.junit.jupiter.api.function.Executable;

import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.entity.Developer;
import com.app.dca.entity.Feed;
import com.app.dca.repository.DeveloperRepository;
import com.app.dca.repository.FeedRepository;
import com.app.dca.service.IDeveloperServiceImpl;
import com.app.dca.service.IFeedServiceImpl;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

public class FeedServiceImplTest {
	FeedRepository feedRepo;
	DeveloperRepository devRepo;
	private static IFeedServiceImpl feedService;
	private static IDeveloperServiceImpl devService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
		feedRepo = mock(FeedRepository.class); // test through approach 2
		feedService = new IFeedServiceImpl(feedRepo);	// Approach 2
		devRepo = mock(DeveloperRepository.class);
		devService = new IDeveloperServiceImpl(devRepo);
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	Developer d = new Developer(3, "abc", "abc@gmail.com", "Medium",LocalDate.of(2020, 05, 29),null,2,11,true,false);

	@Test
	//@Disabled
	@DisplayName("Test-Save feed")
	void testSaveFeed() {
		Feed input = new Feed(10,"what is JDBC",LocalDate.of(2021,03,25), LocalTime.of(4, 23, 12),"JDBC",10,d,1);
		Feed savedFeed = new Feed(10,"what is JDBC",LocalDate.of(2021,03,25), LocalTime.of(4, 23, 12),"JDBC",10,d,1);
	
		when(feedRepo.save(input)).thenReturn(savedFeed);
		feedService.addFeed(input);
		verify(feedRepo).save(input);
		
	}
	
	
	
	@Test
	//@Disabled
	@DisplayName("Test-edit Feed")
	
	void testeditFeed() throws UnknownFeedException {
		Feed input = new Feed(10,"what is JDBC",LocalDate.of(2021,03,25), LocalTime.of(4, 23, 12),"JDBC",10,d,1);
		Feed savedFeed = new Feed(10,"what is JDBC",LocalDate.of(2021,03,25), LocalTime.of(4, 23, 12),"JDBC",10,d,1);
	
		when(feedRepo.save(input)).thenReturn(savedFeed);
		feedService.editFeed(input);
		verify(feedRepo).save(input);
		
	}
	
	
	
	@Test
	//@Disabled
	@DisplayName("Test-Delete feed")
	void testDeleteFeed() throws UnknownFeedException {
		
		Feed input = new Feed(10,"what is JDBC",LocalDate.of(2021,03,25), LocalTime.of(4, 23, 12),"JDBC",10,d,1);
		Feed savedFeed = new Feed(10,"what is JDBC",LocalDate.of(2021,03,25), LocalTime.of(4, 23, 12),"JDBC",10,d,1);

	
		when(feedRepo.findById(input.getFeedId())).thenReturn(Optional.of(savedFeed));
		feedService.removeFeed(input.getFeedId());
		verify(feedRepo).deleteById(input.getFeedId());
		assertEquals(input, savedFeed);
	
	}
	
	
	
	
	@Test
	//@Disabled
	@DisplayName("Test-Get Feed by Developer")
	void testgetFeedByDeveloper() throws UnknownDeveloperException{
		
		
		int input = 1;
		Feed feed = mock(Feed.class);
		 Optional<List<Feed>> optionalFeed = Optional.empty();
		when(feedRepo.getFeedsByDeveloper(input)).thenReturn(optionalFeed);
		Executable executable = ()->feedService.getFeedsByDeveloper(input);
		assertThrows(UnknownDeveloperException.class, executable);
		
	}
	
	
	@Test
	//@Disabled
	@DisplayName("Test-Get All Feeds")
	void testGetAllFeeds() {
		
		
		List<Feed> feedList = mock(List.class); 
		//when() and 	//thenReturn()
		when(feedRepo.findAll()).thenReturn(feedList);
		//call the actual method 
		feedService.getAllFeeds();
		verify(feedRepo).findAll();
		
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Get Feed by Topic")
	void testgetFeedByTopic(){
		
		
		String topic = "Java";
		 Optional<List<Feed>> optionalFeed = Optional.empty();
		when(feedRepo.getFeedsByTopic(topic)).thenReturn(optionalFeed);
		Executable executable = ()->feedService.getFeedsByTopic(topic);
		
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Get Feed by Keyword")
	void testgetFeedByKeyword(){
		
		
		String Keyword = "JDBC";
		 Optional<List<Feed>> optionalFeed = Optional.empty();
		when(feedRepo.getFeedsByKeyWord(Keyword)).thenReturn(optionalFeed);
		Executable executable = ()->feedService.getFeedsByTopic(Keyword);
		
	}
	
		
	
}