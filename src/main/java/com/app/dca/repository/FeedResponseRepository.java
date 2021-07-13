package com.app.dca.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dca.entity.Feedresponse;

public interface FeedResponseRepository extends JpaRepository<Feedresponse, Integer>,CustomFeedResponseRepository{

}
