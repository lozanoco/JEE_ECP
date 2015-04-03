package views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import controllers.DeleteTopicController;
import controllers.VoteController;
import persistence.models.entities.Topic;

@ManagedBean
@ViewScoped
public class DeleteTopicBean extends GenericBean{

	private static final long serialVersionUID = 7389408341421311664L;
	private String token;
	private Integer topicId;
	private boolean authorized;
	private Topic topic;

	private List<Topic> topics;

	public DeleteTopicBean() {
	}
	@PostConstruct
	public void init() {
		this.topics = new ArrayList<Topic>();
		this.topic = new Topic();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token=token;
	}

	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String process() {
		DeleteTopicController deleteTopicController = this.getControllerFactory().getDeleteTopicController();
		VoteController voteController = this.getControllerFactory().getVoteController();
		this.setAuthorized(deleteTopicController.authorize(this.getAuthorized()));
		if(this.isAuthrorized()){
			if (this.getTopicId() != null) {
				deleteTopicController.deleteTopic(this.getTopicId());
			}
			this.setTopics(voteController.obtainTopics());
			this.setTopic(new Topic());
			this.setAuthorized(true);
		}
		else{
			this.setAuthorized(false);
		}
		if(token == null && topicId != null){
			this.getControllerFactory().getDeleteTopicController().deleteTopic(topicId);
		}else if(token != null && !token.equals("")){
			authorized = this.getControllerFactory().getDeleteTopicController().authorize(token);
		}
		return "Home";
	}

	public boolean isAuthrorized() {
		return authorized;
	}

	public String getAuthorized() {
		return this.token;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
}
