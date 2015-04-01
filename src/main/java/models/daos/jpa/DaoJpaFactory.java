package models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;




import org.eclipse.persistence.config.PersistenceUnitProperties;

import models.daos.DaoFactory;
import models.daos.TopicDao;
import models.daos.VoteDao;


public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "JEE_ECP";

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
		return new VoteDaoJpa();
	}

	@Override
	public TopicDao getTopicDao() {
		return new TopicDaoJpa();
	}

	public static void dropAndCreateTables() {
		Map<String, String> properties = new HashMap<>();
		properties.put(PersistenceUnitProperties.DDL_GENERATION,
				PersistenceUnitProperties.DROP_AND_CREATE);
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
		LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
		
	}


}
