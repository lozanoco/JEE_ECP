package models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;



import models.daos.DaoFactory;
import models.daos.TopicDao;
import models.daos.VoteDao;


public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

	@Override
	public VoteDao getVoteDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TopicDao getTopicDao() {
		// TODO Auto-generated method stub
		return null;
	}


}
