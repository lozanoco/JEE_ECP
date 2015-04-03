package controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.EqualExpression;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TopicDao;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Topic;
import persistence.models.entities.Vote;
import persistence.models.utils.levelEducation;
import controllers.VoteController;

public class VoteEjbController implements VoteController{

	@Override
	public List<Topic> obtainTopics() {
		DaoFactory.setFactory(new DaoJpaFactory());
		TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		return topicDao.findAll();
	}

	@Override
	public Topic findTopic(Integer id) {
		DaoFactory.setFactory(new DaoJpaFactory());
		TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		return topicDao.read(id);
	}

	@Override
	public void vote(Topic topic, Vote vote) {
		DaoFactory.setFactory(new DaoJpaFactory());
		TopicDao topicDao = DaoFactory.getFactory().getTopicDao();
		Topic topicPersist = topicDao.read(topic.getId());
		topicPersist.setVote(vote);
		topicDao.update(topicPersist);
	}

	@Override
	public List<String> getLevelEducation() {
		List<String> educationLevel = new ArrayList<String>();
		for(levelEducation level : levelEducation.values()){
			educationLevel.add(level.toString());
		}
		return educationLevel;
	}

	@Override
	public Vote createVote(Integer score, String ip,
			String educationLevel) {
		if(educationLevel.equals(levelEducation.HIGHER.toString())){
			return new Vote(ip, score, levelEducation.HIGHER);
		}else if(educationLevel.equals(levelEducation.PRIMARY.toString())){
			return new Vote(ip, score, levelEducation.PRIMARY);
		}else if(educationLevel.equals(levelEducation.SECONDARY.toString())){
			return new Vote(ip, score, levelEducation.SECONDARY);
		}
		else return new Vote(ip, score, levelEducation.PRIMARY);
	}

	@Override
	public Topic getTopic(Integer id) {
		return DaoFactory.getFactory().getTopicDao().read(id);
	}

}
