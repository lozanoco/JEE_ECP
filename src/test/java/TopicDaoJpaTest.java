
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

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
		Vote vote1 = new Vote("180.5.5.5", 5, levelEducation.PRIMARY);
		Vote vote2 = new Vote("180.6.6.6", 7, levelEducation.HIGHER);
		this.topic.setVote(vote1);
		this.topic.setVote(vote2);
		topicDao.create(topic);
	}

	@Test
	public void testRead() {
		assertEquals(topic, topicDao.read(topic.getId()));
	}
	
	@Test
    public void testReadVotes() {
        assertEquals(topic.getVoteList(), topicDao.read(topic.getId()).getVoteList());
    }
    
    @Test
    public void testReadVote() {        
        for(int i=0;i<topic.getVoteList().size();i++) {
        	assertEquals(topic.getVoteList().get(i), topicDao.read(topic.getId()).getVoteList().get(i));
        }
    }

	@Test
	public void testUpdateTopic() {
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
