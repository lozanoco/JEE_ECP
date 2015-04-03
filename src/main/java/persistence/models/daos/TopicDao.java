package persistence.models.daos;

import java.util.HashMap;

import persistence.models.entities.Topic;
import persistence.models.utils.levelEducation;

public interface TopicDao extends GenericDao <Topic, Integer>{
	
	boolean topicExist(String name);

	HashMap<levelEducation, Double> averagePerLevelEducation(Integer id);

}
