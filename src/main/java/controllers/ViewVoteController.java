package controllers;

import java.util.HashMap;
import java.util.List;

import persistence.models.entities.Topic;
import persistence.models.utils.levelEducation;

public interface ViewVoteController {

	Integer getNVotes(Topic topic);

	HashMap<levelEducation, Double> getAveragePerEducationLevel(Topic topic);
	
	List<Integer> obtainListVotesForTopic(List<Topic> topics);
	
	List<List<Double>> obtainListVotesForTopicAndEducation(List<Topic> topic);

	List<String> obtainColumnHeaders();
	
	List<Double> average(List<Topic> topic, String educationLevel);

}
