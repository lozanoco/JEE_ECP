package views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		if(token == null && topicId != null){
			this.getControllerFactory().getDeleteTopicController().deleteTopic(topicId);
		}else if(token != null && !token.equals("")){
			authorized = this.getControllerFactory().getDeleteTopicController().authorize(token);
		}
		return "DeleteTopic";
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
