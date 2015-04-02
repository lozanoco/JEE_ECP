package persistence.models.daos.jpa;

import persistence.models.daos.TopicDao;
import persistence.models.entities.Topic;

public class TopicDaoJpa extends GenericDaoJpa<Topic,Integer> implements TopicDao {

	public TopicDaoJpa() {
		super(Topic.class);
	}

}
