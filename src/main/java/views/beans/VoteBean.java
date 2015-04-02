package views.beans;

import java.util.List;
import org.apache.logging.log4j.LogManager;

import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Topic;


public class VoteBean extends GenericBean{

	private static final long serialVersionUID = 1L;
	
	List<Topic> topics;
	
	public VoteBean() {
		topics = chargeTopics();
	}

	private List<Topic> chargeTopics() {
		return DaoJpaFactory.getFactory().getTopicDao().findAll();
	}

	@Override
	public void update() {
		LogManager.getLogger(VoteBean.class).debug(
                "Recupera temas del Negocio");
        this.topics = null;		
	}

	@Override
	public String process() {
		// TODO Auto-generated method stub
		return null;
	}

}
