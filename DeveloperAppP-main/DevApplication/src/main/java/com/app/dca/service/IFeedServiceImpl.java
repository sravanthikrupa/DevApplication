package com.app.dca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Developer;
import com.app.dca.entity.Feed;
import com.app.dca.entity.FeedResponse;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.exception.UnknownFeedResponseException;
import com.app.dca.repository.DeveloperRepository;
import com.app.dca.repository.FeedRepository;
import com.app.dca.repository.FeedResponseRepository;

@Service
public class IFeedServiceImpl implements IFeedService{

	@Autowired
	private FeedRepository feedRepo;
	@Autowired
	private DeveloperRepository devRepo;
	
	public IFeedServiceImpl(FeedRepository feedRepo) {
		// TODO Auto-generated constructor stub
		super();
		this.feedRepo=feedRepo;
	}
	

	public IFeedServiceImpl(DeveloperRepository devRepo) {
		super();
		this.devRepo = devRepo;
	}


	@Override
	@Transactional
	public Feed addFeed(Feed feed){
		return feedRepo.save(feed);
	}

	@Override
	public Feed editFeed(Feed feed) {
		
		return feedRepo.save(feed);
	}

	@Override
	public Feed likeFeed(int feedId){
		Feed f =  feedRepo.findById(feedId).get();
		f.setRelevance(f.getRelevance()+1);
		return f;
	}
	
	
	
	
	
	@Override
	@Transactional
	public Optional<Feed> getFeed(int feedId) throws UnknownFeedException {
		Optional<Feed> f = feedRepo.findById(feedId);
		if(f.isEmpty())
			throw new UnknownFeedException();
		return f;
	}


	

	
	@Override
	public Optional<Feed> removeFeed(int feedId){
		
		Optional<Feed> feed = feedRepo.findById(feedId);
		
	feedRepo.deleteById(feedId);
		return feed;
	}

	@Override
	public List<Feed> getFeedsByDeveloper(int devId) throws UnknownDeveloperException{
	    //Developer d = devServcie.getDeveloper(devId);
	    Developer d = devRepo.findById(devId).get();
	    if(d.equals(null))
	    	throw new UnknownDeveloperException();
	    List<Feed> feed = feedRepo.findAll();
	    List<Feed> newFeed = new ArrayList<>();
	    for (Feed feed2 : feed) {
			if(feed2.getDev().getDevId() == devId)
				newFeed.add(feed2);
		}
		return newFeed;
	}
	
	public void getAllFeeds() {
		feedRepo.findAll();
	}

	@Override
	public  Optional<List<Feed>> getFeedsByKeyword(String keyword) {
		
		return feedRepo.getFeedsByKeyWord(keyword);
	}

	@Override
	public List<Feed> getFeedsByTopic(String topic) {
		
	return feedRepo.getFeedsByTopic(topic);
	}
}


