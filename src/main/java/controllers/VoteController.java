package controllers;

import java.util.List;

import persistence.models.entities.Topic;
import persistence.models.entities.Vote;

public interface VoteController{

	List<Topic> obtainTopics();
	
	Topic findTopic(Integer id);
	
	void vote(Topic topic, Vote vote);
}
