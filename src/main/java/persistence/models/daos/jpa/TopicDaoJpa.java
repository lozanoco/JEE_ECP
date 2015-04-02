package persistence.models.daos.jpa;

import java.util.List;

import persistence.models.daos.TopicDao;
import persistence.models.entities.Topic;

public class TopicDaoJpa extends GenericDaoJpa<Topic,Integer> implements TopicDao {

	public TopicDaoJpa() {
		super(Topic.class);
	}
	
	@Override
	public boolean topicExist(String name) {
		List<Topic> topics = this.findAll();
		for (Topic topic : topics) {
			if(topic.getName().equals(name))
				return true;
		}
		return false;
	}

}
