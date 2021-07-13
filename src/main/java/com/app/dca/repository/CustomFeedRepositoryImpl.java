package com.app.dca.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dca.entity.Feed;



public class CustomFeedRepositoryImpl implements CustomFeedRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public Optional<List<Feed>> getFeedsByTopic(String feedTopic) {
		
		Query q = entityManager.createQuery("from Feed where topic=:feedTopic");
		q.setParameter("feedTopic", feedTopic);
		 return Optional.of(q.getResultList());
	}

	@Override
	public Optional<List<Feed>> getFeedsByKeyWord(String keyword) {
		Query q = entityManager.createQuery("from Feed where queryQ like :keyword");
		q.setParameter("keyword", "%"+keyword+"%");
		 return Optional.of(q.getResultList());
	}

	@Override
	public Optional<List<Feed>> getFeedsByDeveloper(int devId) {
	     Query q = entityManager.createQuery("from Feed where Dev_Id=:devId");
	     q.setParameter("devId", devId);
	     return Optional.of(q.getResultList());
	}



}
