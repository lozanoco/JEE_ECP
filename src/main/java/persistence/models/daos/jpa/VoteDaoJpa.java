package persistence.models.daos.jpa;
import persistence.models.daos.VoteDao;
import persistence.models.entities.Vote;

public class VoteDaoJpa extends GenericDaoJpa<Vote,Integer> implements VoteDao {

	public VoteDaoJpa() {
		super(Vote.class);
	}
}
