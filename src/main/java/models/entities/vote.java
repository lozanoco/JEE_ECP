package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.utils.levelEducation;

@Entity
public class vote {
	@Id
	@GeneratedValue
	private int id;
	
	private String ip;
	private int score;
	private levelEducation education;
	
	public vote(){}
	
	public vote(String ip,int score,levelEducation education){
		super();
        this.score = score;
        this.ip = ip;
        this.education=education;
	}

}
