package controllers.ejb;

import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TopicDao;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Topic;
import persistence.models.entities.Vote;
import controllers.VoteController;

public class VoteEjbController implements VoteController{

	@Override
	public List<Topic> obtainTopics() {
		DaoFactory.setFactory(new DaoJpaFactory());
        TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		return topicDao.findAll();
	}

	@Override
	public Topic findTopic(Integer id) {
		DaoFactory.setFactory(new DaoJpaFactory());
        TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		return topicDao.read(id);
	}

	@Override
	public void vote(Topic topic, Vote vote) {
		DaoFactory.setFactory(new DaoJpaFactory());
        TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
        Topic topicPersist = topicDao.read(topic.getId());
        topicPersist.setVote(vote);
        topicDao.update(topicPersist);
	}

}
