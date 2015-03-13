package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class vote4topic {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String vote;
	private String topic;
	
	public vote4topic(){}
	
	public vote4topic(String vote,String topic){
		super();
        this.topic = topic;
        this.vote = vote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
