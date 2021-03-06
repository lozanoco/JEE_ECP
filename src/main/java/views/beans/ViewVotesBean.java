package views.beans;

import java.util.HashMap;

import persistence.models.entities.Topic;
import persistence.models.utils.levelEducation;

public class ViewVotesBean extends ListTopicsBean{

	private static final long serialVersionUID = 1L;
	
	private Integer nVotes;
	
	private levelEducation[] educationLevel;
	
	private HashMap<levelEducation, Double> average;
	
	private Topic topic;

	public String process() {
		if(topic != null){
			this.nVotes = this.getControllerFactory().getViewVoteController().getNVotes(topic);
			this.average = this.getControllerFactory().getViewVoteController().getAveragePerEducationLevel(topic);
			this.educationLevel=  this.getControllerFactory().getVoteController().getLevelEducationArray();
		}
		return "ViewVotes";
	}

	public Integer getnVotes() {
		return nVotes;
	}
	
	public void setnVotes(Integer nVotes) {
		this.nVotes = nVotes;
	}

	public levelEducation[] getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(levelEducation[] educationLevel) {
		this.educationLevel = educationLevel;
	}

	public HashMap<levelEducation, Double> getAverage() {
		return average;
	}

	public void setAverage(HashMap<levelEducation, Double> average) {
		this.average = average;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(int id) {
		this.topic = this.getControllerFactory().getVoteController().getTopic(id);
	}

}
