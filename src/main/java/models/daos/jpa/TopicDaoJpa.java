package models.daos.jpa;

import models.daos.TopicDao;
import models.entities.Topic;

public class TopicDaoJpa extends GenericDaoJpa<Topic,Integer> implements TopicDao {

	public TopicDaoJpa() {
		super(Topic.class);
	}

}
