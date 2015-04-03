package controllers;

public interface DeleteTopicController {

	void deleteTopic(Integer topicId);

	Boolean authorize(String authorization);
}
