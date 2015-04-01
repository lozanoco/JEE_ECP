
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import models.daos.DaoFactory;
import models.daos.TopicDao;
import models.daos.VoteDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Topic;
import models.entities.Vote;
import models.utils.levelEducation;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class TopicDaoJpaTest {
	private TopicDao topicDao;
	private Topic topic;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
	}

	@Before
	public void before(){
		this.topic= new Topic("tema","¿pregunta tema?");
		topicDao = DaoFactory.getFactory().getTopicDao();
		topicDao.create(topic);
	}

	@Test
	public void testRead() {
		assertEquals(topic, topicDao.read(topic.getId()));
	}

	@Test
	public void testUpdateVote() {
		topic.setName("tema1");
		topic.setQuestion("¿question?");
		topic.setId(3);
		topicDao.update(topic);
		assertEquals(topic, topicDao.read(topic.getId()));
	}

	@Test
	public void testDeleteByID() {
		topicDao.deleteById(topic.getId());
		assertNull(topicDao.read(topic.getId()));
		assertNull(DaoFactory.getFactory().getVoteDao().read(topic.getId()));
	}

	@Test
	public void testFindAll() {
		this.topic = new Topic("tema3","¿pregunta tema3?");
		topicDao = DaoFactory.getFactory().getTopicDao();
		topicDao.create(topic);
		assertEquals(2, topicDao.findAll().size());
	}

	@After
	public void after() {
		DaoJpaFactory.dropAndCreateTables();
	}

}
