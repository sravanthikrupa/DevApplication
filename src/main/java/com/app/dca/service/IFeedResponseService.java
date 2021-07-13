package com.app.dca.service;

import java.util.List;
import java.util.Optional;

import com.app.dca.entity.Feedresponse;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.exception.UnknownFeedResponseException;

public interface IFeedResponseService {
	
	Feedresponse addResponse(Feedresponse resp);
	
	Feedresponse editResponse(Feedresponse resp);
	
	Feedresponse removeResponse(int respId) throws UnknownFeedResponseException;
	
	Feedresponse likeResponse(int respId);
	
	Optional<List<Feedresponse>> getResponseByFeed(int feedId) throws UnknownFeedException;
	
	Optional<List<Feedresponse>> getResponseByDeveloper(int devId) throws UnknownDeveloperException;

	Feedresponse editResponse(Feedresponse resp, Integer id);

	List<Feedresponse> getAllResponses();
	
}