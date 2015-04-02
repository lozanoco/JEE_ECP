package controllers.ejb;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TopicDao;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Topic;
import controllers.AddTopicController;

public class AddTopicEjbController implements AddTopicController {

	@Override
	public boolean existTopic(Topic topic) {
		DaoFactory.setFactory(new DaoJpaFactory());
		TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		return topicDao.topicExist(topic.getName());
		
	}

	@Override
	public void addTopic(Topic topic) {
		DaoFactory.setFactory(new DaoJpaFactory());
		TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		topicDao.create(topic);
	}

}
