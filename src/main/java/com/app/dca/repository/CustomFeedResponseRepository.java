package com.app.dca.repository;

import java.util.List;
import java.util.Optional;

import com.app.dca.entity.Feedresponse;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;

public interface CustomFeedResponseRepository {
	public Optional<List<Feedresponse>> getResponseByFeed(int feedId);
	
	public Optional<List<Feedresponse>> getResponseByDeveloper(int devId);
}
