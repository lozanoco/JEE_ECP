package persistence.models.daos.jpa;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import persistence.models.daos.TopicDao;
import persistence.models.entities.Topic;
import persistence.models.utils.levelEducation;

public class TopicDaoJpa extends GenericDaoJpa<Topic,Integer> implements TopicDao {

	public TopicDaoJpa() {
		super(Topic.class);
	}
	
	@Override
	public boolean topicExist(String name) {
		List<Topic> topics = this.findAll();
		for (Topic topic : topics) {
			if(topic.getName().equals(name))
				return true;
		}
		return false;
	}

	@Override
	public HashMap<levelEducation, Double> averagePerLevelEducation(Integer id) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteria.createQuery(Tuple.class);
		Root<Topic> topics = criteriaQuery.from(Topic.class);
		Path<Object> path = topics.join("voteList");
		CriteriaQuery<Tuple> select = criteriaQuery.select(criteria.tuple(path.get("education"), criteria.avg(path.get("score"))));
		select.where(criteria.equal(topics.get("id"), id));
		select.groupBy(path.get("education"));
		List<Tuple> result = entityManager.createQuery(select).getResultList();
		return this.getVotesAverage(result);
	}

	private HashMap<levelEducation, Double> getVotesAverage(List<Tuple> votes) {
		HashMap<levelEducation, Double> averages = new HashMap<levelEducation, Double> ();
		for (Tuple vote : votes) {
			averages.put(levelEducation.valueOf(String.valueOf(vote.get(0))), Double.parseDouble(String.valueOf(vote.get(1))));
		}
		return averages;
	}

}
