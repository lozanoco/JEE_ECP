package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class topic {
	
	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String question;
	
	public topic(int id, String name, String question) {
		super();
		this.id = id;
		this.name = name;
		this.question = question;
	}
	
	public topic(){}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
}
