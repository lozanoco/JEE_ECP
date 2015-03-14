package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.utils.levelEducation;

@Entity
public class Vote {
	public static final String TABLE = "vote";

	@Id
	@GeneratedValue
	private Integer id;
	
	private String ip;
	private int score;
	private levelEducation education;
	
	public Vote(){}
	
	public Vote(String ip,int score,levelEducation education){
		super();
        this.score = score;
        this.ip = ip;
        this.education=education;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public levelEducation getEducation() {
		return education;
	}

	public void setEducation(levelEducation education) {
		this.education = education;
	}
	
	

}