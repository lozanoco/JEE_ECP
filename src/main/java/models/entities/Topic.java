package models.entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic {
	
	public static final String TABLE = "topic";

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String question;
	
	// Relacion unidireccional: 1:0..n
    // Se aplica cascada
    @OneToMany(cascade = CascadeType.ALL)
	private ArrayList<Vote> voteList;
	
	public Topic(int id, String name, String question) {
		super();
		this.id = id;
		this.name = name;
		this.question = question;
	}
	
	public Topic(){}
	

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

	public ArrayList<Vote> getVoteList() {
		return voteList;
	}

	public void setVoteList(ArrayList<Vote> voteList) {
		this.voteList = voteList;
	}
	
}
