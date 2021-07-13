package com.app.dca.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.dca.entity.Feedresponse;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.exception.UnknownFeedResponseException;


public interface IFeedResponseRepository{
	
	Feedresponse saveResponse(Feedresponse resp);
	
	Feedresponse updateResponse(Feedresponse resp);
	
	Feedresponse removeResponse(int respId) throws UnknownFeedResponseException;
	
	Feedresponse likeResponse(int respId);
	
	List<Feedresponse> fetchResponseByFeed(int feedId) throws UnknownFeedException;
	
	List<Feedresponse> fetchResponseByDeveloper(int devId) throws UnknownDeveloperException;
	
	
}