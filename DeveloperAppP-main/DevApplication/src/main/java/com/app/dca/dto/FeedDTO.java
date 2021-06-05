package com.app.dca.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class FeedDTO {
	
   int feedId;
   String queryQ;
   LocalDate feedDate;
   LocalTime feedTime;
   String topic;
   int relevance;
   int totalCommnets;
   
   public FeedDTO() {
	super();
	// TODO Auto-generated constructor stub
   }

public FeedDTO(int feedId, String queryQ, LocalDate feedDate, LocalTime feedTime, String topic, int relevance,
		int totalCommnets) {
	super();
	this.feedId = feedId;
	this.queryQ = queryQ;
	this.feedDate = feedDate;
	this.feedTime = feedTime;
	this.topic = topic;
	this.relevance = relevance;
	this.totalCommnets = totalCommnets;
}

public int getFeedId() {
	return feedId;
}

public void setFeedId(int feedId) {
	this.feedId = feedId;
}

public String getQueryQ() {
	return queryQ;
}

public void setQueryQ(String queryQ) {
	this.queryQ = queryQ;
}

public LocalDate getFeedDate() {
	return feedDate;
}

public void setFeedDate(LocalDate feedDate) {
	this.feedDate = feedDate;
}

public LocalTime getFeedTime() {
	return feedTime;
}

public void setFeedTime(LocalTime feedTime) {
	this.feedTime = feedTime;
}

public String getTopic() {
	return topic;
}

public void setTopic(String topic) {
	this.topic = topic;
}

public int getRelevance() {
	return relevance;
}

public void setRelevance(int relevance) {
	this.relevance = relevance;
}

public int getTotalCommnets() {
	return totalCommnets;
}

public void setTotalCommnets(int totalCommnets) {
	this.totalCommnets = totalCommnets;
}
   
   
   
   
   
}
