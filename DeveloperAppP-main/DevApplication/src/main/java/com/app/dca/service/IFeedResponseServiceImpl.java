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
public class IFeedResponseServiceImpl implements IFeedResponseService {
	
	@Autowired
	private FeedResponseRepository feedResRepo;
	@Autowired
	private FeedRepository fr;
	private DeveloperRepository devRepo;
  	
	public IFeedResponseServiceImpl(FeedResponseRepository feedResRepo) {
		// TODO Auto-generated constructor stub
		super();
		this.feedResRepo=feedResRepo;
	}
	
	
	public IFeedResponseServiceImpl(DeveloperRepository devRepo) {
		super();
		this.devRepo = devRepo;
	}


	@Override
	@Transactional
	public FeedResponse addResponse(FeedResponse resp) {
		
		feedResRepo.save(resp);
		return resp;
	}

	
	@Override
	public FeedResponse editResponse(FeedResponse resp, Integer id) {
		
		return feedResRepo.save(resp);
	}

	@Override
	public FeedResponse removeResponse(int respId) throws UnknownFeedResponseException {
		 FeedResponse f = feedResRepo.findById(respId).get();
		 if(f.equals(null))
			 throw new UnknownFeedResponseException();
		 feedResRepo.deleteById(respId);
		return f;
		
	}

	@Override
	public FeedResponse likeResponse(int respId) {
		
		FeedResponse resp = feedResRepo.findById(respId).get();
		resp.setAccuracy(resp.getAccuracy()+1);
		return resp;
		
		
	}

	@Override
	public List<FeedResponse> getResponseByFeed(int feedId) throws UnknownFeedException {
		Feed f = fr.findById(feedId).get();
		 if(f.equals(null))
			 throw new UnknownFeedException();
		 List<FeedResponse> feedResponse = feedResRepo.findAll();
		 List<FeedResponse> newFeedResponse = new ArrayList<>(); 
		 for (FeedResponse feedResponse2 : feedResponse) {
			  if(feedResponse2.getFeed().getFeedId() == feedId)
				  newFeedResponse.add(feedResponse2);
		}
		return newFeedResponse;
	}
	
	@Override
	public List<FeedResponse> getResponseByDeveloper(int devId) throws UnknownDeveloperException {
		//Developer d = dr.findById(devId).get();
		Developer d = devRepo.findById(devId).get();
	    if(d.equals(null))
	    	throw new UnknownDeveloperException();
	    List<FeedResponse> feedresponse = feedResRepo.findAll();
	    List<FeedResponse> newFeedResponse = new ArrayList<>();
	    for (FeedResponse feedResponse2 : feedresponse) {
			if(feedResponse2.getDev().getDevId() == devId)
				newFeedResponse.add(feedResponse2);
		}
		return newFeedResponse;
		
            
	}


	@Override
	public FeedResponse editResponse(FeedResponse resp) {
		
		return feedResRepo.save(resp);
	}


	@Override
	public List<FeedResponse> getAllResponses() {

		return feedResRepo.findAll();
	}
	
	



} //end class