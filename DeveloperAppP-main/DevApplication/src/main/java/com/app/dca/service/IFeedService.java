package com.app.dca.service;

import java.util.List;
import java.util.Optional;

import com.app.dca.entity.Feed;
import com.app.dca.exception.*;
public interface IFeedService {

	Feed addFeed(Feed feed);
	
	Feed editFeed(Feed feed);
	
	Feed likeFeed(int feedId);
	
	Optional<Feed> getFeed(int feedId) throws UnknownFeedException;
	
	Optional<Feed> removeFeed(int feedId);
	//jpql
	List<Feed> getFeedsByDeveloper(int devId) throws UnknownDeveloperException;
	
	Optional<List<Feed>> getFeedsByKeyword(String keyword);
	
	List<Feed> getFeedsByTopic(String topic);
}