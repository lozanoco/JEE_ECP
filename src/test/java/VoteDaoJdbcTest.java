import models.daos.DaoFactory;
import models.daos.VoteDao;
import models.daos.jdbc.DaoJdbcFactory;
import models.entities.Vote;
import models.utils.levelEducation;


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
}
