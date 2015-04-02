import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.VoteDao;
import persistence.models.daos.jdbc.DaoJdbcFactory;
import persistence.models.entities.Vote;
import persistence.models.utils.levelEducation;



public class VoteDaoJdbcTest {
	private VoteDao voteDao;
	private Vote vote;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJdbcFactory());
		DaoJdbcFactory.dropAndCreateTables();
	}

	@Before
	public void before(){
		this.vote= new Vote("180.5.5.5", 5, levelEducation.PRIMARY);
		voteDao = DaoFactory.getFactory().getVoteDao();
		voteDao.create(vote);
	}

	@Test
	public void testRead() {
		assertEquals(vote, voteDao.read(vote.getId()));
	}

	@Test
	public void testUpdateCategory() {
		vote.setScore(6);
		vote.setEducation(levelEducation.HIGHER);
		vote.setIp("1.1.1.1");
		vote.setId(3);
		voteDao.update(vote);
		assertEquals(vote, voteDao.read(vote.getId()));
	}

	@Test
	public void testDeleteByID() {
		voteDao.deleteById(vote.getId());
		assertNull(voteDao.read(vote.getId()));
		assertNull(DaoFactory.getFactory().getVoteDao().read(vote.getId()));
	}

	@Test
	public void testFindAll() {
		this.vote = new Vote("ip", 4, levelEducation.SECONDARY);
		voteDao = DaoFactory.getFactory().getVoteDao();
		voteDao.create(vote);
		assertEquals(2, voteDao.findAll().size());
	}


	@After
	public void after() {
		DaoJdbcFactory.dropAndCreateTables();
	}

}
