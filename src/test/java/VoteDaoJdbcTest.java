import models.daos.DaoFactory;
import models.daos.VoteDao;
import models.daos.jdbc.DaoJdbcFactory;
import models.entities.Vote;


public class VoteDaoJdbcTest {
	private VoteDao dao;
	private Vote vote;
	
	  @BeforeClass
	    public static void beforeClass() {
	        DaoFactory.setFactory(new DaoJdbcFactory());
	        DaoJdbcFactory.dropAndCreateTables();
	    }
}
