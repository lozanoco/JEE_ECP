package controllers;

import persistence.models.entities.Topic;

public interface AddTopicController {

	boolean existTopic(Topic topic);

	void addTopic(Topic topic);

}
