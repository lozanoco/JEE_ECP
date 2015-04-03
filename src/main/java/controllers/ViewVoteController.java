package controllers;

import java.util.HashMap;
import java.util.List;

import persistence.models.entities.Topic;
import persistence.models.utils.levelEducation;

public interface ViewVoteController {

	int getNVotes(Topic topic);
	
	HashMap<levelEducation, Double> getAveragePerEducationLevel(Topic topic);

}
