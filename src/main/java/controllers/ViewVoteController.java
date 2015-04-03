package controllers;

import java.util.HashMap;

import persistence.models.entities.Topic;
import persistence.models.utils.levelEducation;

public interface ViewVoteController {

	Integer getNVotes(Topic topic);

	HashMap<levelEducation, Double> getAveragePerEducationLevel(Topic topic);

}
