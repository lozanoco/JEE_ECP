package controllers;

import java.util.List;

import persistence.models.entities.Topic;
import persistence.models.entities.Vote;
import persistence.models.utils.levelEducation;

public interface VoteController{

	List<Topic> obtainTopics();
	
	Topic findTopic(Integer id);
	
	void vote(Topic topic, Vote vote);
	
	List<String> getLevelEducation();
	
	Vote createVote(Integer score, String ip, String levelEducation);

	Topic getTopic(Integer id);
}
