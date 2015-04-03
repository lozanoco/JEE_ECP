package controllers;

public abstract class ControllerFactory {
	
	public abstract VoteController getVoteController();

	public abstract AddTopicController getAddTopicController();

	public abstract DeleteTopicController getDeleteTopicController();
}
