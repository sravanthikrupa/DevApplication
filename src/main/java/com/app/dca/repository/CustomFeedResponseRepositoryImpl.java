package com.app.dca.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dca.entity.Feedresponse;

public class CustomFeedResponseRepositoryImpl implements CustomFeedResponseRepository{
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Optional<List<Feedresponse>> getResponseByFeed(int feedId){
		 Query q = entityManager.createQuery("from Feedresponse where FEED_ID=:feedId");
	     q.setParameter("feedId",feedId);
	     return Optional.of(q.getResultList());
	}

	@Override
	public Optional<List<Feedresponse>> getResponseByDeveloper(int devId) {
		 Query q = entityManager.createQuery("from Feedresponse where Dev_Id=:devId");
	     q.setParameter("devId", devId);
	     return Optional.of(q.getResultList());
	}

	
}
