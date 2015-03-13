package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class vote4topic {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String vote;
	private String topic;
	
	public vote4topic(){}
	
	public vote4topic(String vote,String topic){
		super();
        this.topic = topic;
        this.vote = vote;
	}

}
