import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import models.daos.DaoFactory;
import models.daos.VoteDao;
import models.daos.jdbc.DaoJdbcFactory;
import models.entities.Vote;
import models.utils.levelEducation;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class VoteDaoJdbcTest {
	private VoteDao dao;
	private Vote vote;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJdbcFactory());
		DaoJdbcFactory.dropAndCreateTables();
	}

	@Before
	public void before(){
		vote= new Vote("180.5.5.5", 5, levelEducation.PRIMARY);
		dao = DaoFactory.getFactory().getVoteDao();
		dao.create(vote);
	}

	 @Test
	    public void testRead() {
	        assertEquals(vote, dao.read(vote.getId()));
	    }

	    @Test
	    public void testUpdateCategory() {
	        vote.setScore(6);
	        vote.setEducation(levelEducation.HIGHER);
	        vote.setIp("1.1.1.1");
	        vote.setId(3);
	        dao.update(vote);
	        assertEquals(vote, dao.read(vote.getId()));
	    }

	    @Test
	    public void testDeleteByID() {
	        dao.deleteById(vote.getId());
	        assertNull(dao.read(vote.getId()));
	        assertNull(DaoFactory.getFactory().getVoteDao().read(vote.getId()));
	    }

	    @Test
	    public void testFindAll() {
	        vote = new Vote("ip", 4, levelEducation.SECONDARY);
	        dao = DaoFactory.getFactory().getVoteDao();
	        dao.create(vote);
	        assertEquals(2, dao.findAll().size());
	    }


	@After
	public void after() {
		DaoJdbcFactory.dropAndCreateTables();
	}

}
