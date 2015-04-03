package controllers.ejb;

import java.util.HashMap;

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

}
