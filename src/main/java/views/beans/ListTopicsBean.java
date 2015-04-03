package views.beans;

import java.util.List;

import persistence.models.entities.Topic;

public abstract class ListTopicsBean extends GenericBean{

	private static final long serialVersionUID = -6716813194528031720L;

	private List<Topic> topics;

	public void update(){
		this.topics = this.getControllerFactory().getVoteController().obtainTopics();
		dataUpdate();
	}

	public abstract void dataUpdate();

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

}
