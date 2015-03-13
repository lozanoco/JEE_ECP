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
	
	public topic(){}
	
	public topic(String name,String question){
		super();
        this.name = name;
        this.question = question;
	}
	
}
