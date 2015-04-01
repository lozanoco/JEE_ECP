package models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic {
	
	public static final String TABLE = "topic";

	public static final String ID = "ID";
	@Id
	@GeneratedValue
	private Integer id;

	public static final String NAME = "NAME";
	private String name;
	public static final String QUESTION = "QUESTION";
	private String question;
	
	// Relacion unidireccional: 1:0..n
    // Se aplica cascada
    @OneToMany(cascade = CascadeType.ALL)
	private List<Vote> voteList;
	
	public Topic(String name, String question) {
		super();
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

	public List<Vote> getVoteList() {
		return voteList;
	}

	public void setVoteList(ArrayList<Vote> voteList) {
		this.voteList = voteList;
	}
	
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		Topic other = (Topic) obj;
		boolean result = id.equals(other.id) && name.equals(other.name) &&
				question.equals(other.question);

		return result;
	}

	
}
