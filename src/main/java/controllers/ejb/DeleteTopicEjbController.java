package controllers.ejb;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TopicDao;
import persistence.models.daos.jpa.DaoJpaFactory;
import controllers.DeleteTopicController;

public class DeleteTopicEjbController implements DeleteTopicController{
	
	private static final String CLAVE = "666";

	@Override
	public void deleteTopic(Integer topicId) {
		DaoFactory.setFactory(new DaoJpaFactory());
		TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		topicDao.deleteById(topicId);
	}
	
	@Override
	public Boolean authorize(String authorization) {
		return CLAVE.equals(authorization);
	}

}
