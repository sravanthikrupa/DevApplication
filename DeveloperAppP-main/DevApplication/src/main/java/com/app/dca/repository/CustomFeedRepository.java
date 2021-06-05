package com.app.dca.repository;

import java.util.List;
import java.util.Optional;

import com.app.dca.entity.Feed;

public interface CustomFeedRepository {
   public List<Feed> getFeedsByTopic(String topic);
   public Optional<List<Feed>> getFeedsByKeyWord(String keyword);
}
