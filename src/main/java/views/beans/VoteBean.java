package views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;

import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Topic;
import persistence.models.entities.Vote;
import persistence.models.utils.levelEducation;
import controllers.VoteController;

@ManagedBean
@ViewScoped
public class VoteBean extends GenericBean{

	private static final long serialVersionUID = 1L;

	public VoteBean() {
	}

	private String levelEducation;

	private List<String> levelEducationList = new ArrayList<String>();

	private Topic topic;

	private Integer value;

	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	private Integer topicId;

	private String question;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	private List<Topic> topics = new ArrayList<Topic>();

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}	


	public void update() {
		VoteController voteController = this.getControllerFactory().getVoteController();
		this.setTopics(voteController.obtainTopics());
		this.setEducationLevelList(voteController.getLevelEducation());

	}
	public void chargeData(Topic vote){
		this.topicId=vote.getId();
		this.question=vote.getQuestion();
	}

	public String process() {
		if (value !=null) {
			this.getControllerFactory().getVoteController().vote(topic, createVote());
		}
		return "Votar";
	}

	private Vote createVote() {
		return this.getControllerFactory().getVoteController().createVote(value, this.ip, this.levelEducation);
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Integer id) {
		this.topic =  this.getControllerFactory().getVoteController().getTopic(id);
	}

	public String getEducationLevel() {
		return levelEducation;
	}

	public void setEducationLevel(String levelEducation) {
		this.levelEducation = levelEducation;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public void setEducationLevelList(List<String> educationLevelList) {
		this.setLevelEducationList(educationLevelList);
	}

	public List<String> getLevelEducationList() {
		return levelEducationList;
	}

	public void setLevelEducationList(List<String> levelEducationList) {
		this.levelEducationList = levelEducationList;
	}

	public void setValue(int value) {
		this.value=value;
		
	}

	public void setLevelEducation(levelEducation education) {
		this.levelEducation=education.toString();
		
	}


}
