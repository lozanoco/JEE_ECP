package views.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import controllers.AddTopicController;
import persistence.models.entities.Topic;

@ManagedBean
@ViewScoped
public class AddTopicBean extends GenericBean{

	private static final long serialVersionUID = 345715435620143597L;

	@PostConstruct
	public void init() {
		this.topic = new Topic();
	}

	private boolean error;

	private Topic topic;

	public AddTopicBean() {
	}

	public AddTopicBean(Topic topic) {
		this.topic = topic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String process() {
		AddTopicController addTopicController = this.getControllerFactory()
				.getAddTopicController();
		if (addTopicController.existTopic(this.getTopic())) {
			this.setError(true);
		} else {
			addTopicController.addTopic(this.getTopic());
			this.setTopic(new Topic());
			this.setError(false);
		}
		return "Home";
	}

}
