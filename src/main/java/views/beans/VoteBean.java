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

    private Vote vote = new Vote();

    private Topic topic = new Topic();

    private Integer topicId;

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

	public String process() {
		VoteController voteController= this.getControllerFactory().getVoteController();
		if (vote.getScore() >0) {
            voteController.vote(this.getTopic(), this.getVote());
            this.setVote(new Vote());
            this.setTopic(new Topic());
            this.setTopics(voteController.obtainTopics());
            this.setEducationLevelList(voteController.getLevelEducation());
        } else {
            if (this.getTopic().getId() >=0) {
                this.setTopics(voteController.obtainTopics());
            } else {
                this.setTopic(voteController.findTopic(this.getTopic().getId()));
                this.setEducationLevelList(voteController.getLevelEducation());
            }
        }
		return null;
	}
	
	public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
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
        this.levelEducationList = educationLevelList;
    }


}
