package com.app.dca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Developer;
import com.app.dca.entity.Feed;
import com.app.dca.entity.Feedresponse;
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
	
  	
	public IFeedResponseServiceImpl(FeedResponseRepository feedResRepo) {
		// TODO Auto-generated constructor stub
		super();
		this.feedResRepo=feedResRepo;
	}
	
	


	@Override
	@Transactional
	public Feedresponse addResponse(Feedresponse resp) {
		
		feedResRepo.save(resp);
		return resp;
	}

	
	@Override
	public Feedresponse editResponse(Feedresponse resp, Integer id) {
		
		return feedResRepo.save(resp);
	}

	@Override
	public Feedresponse removeResponse(int respId) throws UnknownFeedResponseException {
		 Optional<Feedresponse> f = feedResRepo.findById(respId);
		 if(f.isEmpty())
			 throw new UnknownFeedResponseException();
		 feedResRepo.deleteById(respId);
		return f.get();
		
	}

	@Override
	public Feedresponse likeResponse(int respId) {
		
		Feedresponse resp = feedResRepo.findById(respId).get();
		resp.setAccuracy(resp.getAccuracy()+1);
		return resp;
		
		
	}

	@Override
	public Optional<List<Feedresponse>> getResponseByFeed(int feedId) throws UnknownFeedException {
		Optional<List<Feedresponse>> feedResponse = feedResRepo.getResponseByFeed(feedId);
		if(feedResponse==null || feedResponse.isEmpty()) {
			throw new UnknownFeedException(feedId);
		}
		return feedResponse;
	}
	
	@Override
	public Optional<List<Feedresponse>> getResponseByDeveloper(int devId) throws UnknownDeveloperException {
		Optional<List<Feedresponse>> feedResponse = feedResRepo.getResponseByDeveloper(devId);
		if(feedResponse==null || feedResponse.isEmpty()) {
			throw new UnknownDeveloperException(devId);
		}
	   
		return feedResponse;
            
	}


	@Override
	public Feedresponse editResponse(Feedresponse resp) {
		
		return feedResRepo.save(resp);
	}


	@Override
	public List<Feedresponse> getAllResponses() {

		return feedResRepo.findAll();
	}
	
	

} //end class