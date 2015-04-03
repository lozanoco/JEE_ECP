package controllers.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Topic;
import persistence.models.entities.Vote;
import persistence.models.utils.levelEducation;
import controllers.ViewVoteController;

public class viewVoteEjbController implements ViewVoteController {

	@Override
	public int getNVotes(Topic topic) {
		return topic.getVoteList().size();
	}

	@Override
	public HashMap<levelEducation, Double> getAveragePerEducationLevel(
			Topic topic) {
		return DaoFactory.getFactory().getTopicDao().averagePerLevelEducation(topic.getId());
	}


}
