package controllers.ejb;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TopicDao;
import persistence.models.daos.jpa.DaoJpaFactory;
import controllers.DeleteTopicController;

public class DeleteTopicEjbController implements DeleteTopicController{

	@Override
	public void deleteTopic(Integer topicId) {
		DaoFactory.setFactory(new DaoJpaFactory());
		TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		topicDao.deleteById(topicId);
		
	}

}
