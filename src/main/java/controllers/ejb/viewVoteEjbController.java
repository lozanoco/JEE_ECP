package controllers.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Topic;
import persistence.models.utils.levelEducation;
import controllers.ViewVoteController;

public class viewVoteEjbController implements ViewVoteController {

	@Override
	public Integer getNVotes(Topic topic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<levelEducation, Double> getAveragePerEducationLevel(
			Topic topic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> obtainListVotesForTopic(List<Topic> topics) {
		List<Integer> numVotesForTopic = new ArrayList<Integer>();
		DaoFactory.setFactory(new DaoJpaFactory());
		for(Topic topic : topics) {
			numVotesForTopic.add(topic.getVoteList().size());
		}
    	return numVotesForTopic;
	}

	@Override
	public List<List<Double>> obtainListVotesForTopicAndEducation(
			List<Topic> topics) {
		List<List<Double>> numVotesForTopicAndEducation = new ArrayList<List<Double>>();
		DaoFactory.setFactory(new DaoJpaFactory());
		for(levelEducation educationLevel : levelEducation.values()) {
			numVotesForTopicAndEducation.add(average(topics, educationLevel.toString()));
		}
		return numVotesForTopicAndEducation;
	}

	@Override
	public List<String> obtainColumnHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Double> average(List<Topic> topic, String educationLevel) {
		// TODO Auto-generated method stub
		return null;
	}



}
