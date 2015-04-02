package views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;

import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Topic;
import persistence.models.entities.Vote;
import persistence.models.utils.levelEducation;
import controllers.VoteController;

@ManagedBean
@ViewScoped
public class VoteBean extends GenericBean{

	private static final long serialVersionUID = 1L;

	List<Topic> topics;

	public VoteBean() {
		topics = chargeTopics();
	}

	private List<Topic> chargeTopics() {
		return DaoJpaFactory.getFactory().getTopicDao().findAll();
	}

	public void update() {
		LogManager.getLogger(VoteBean.class).debug("Recupera temas del Negocio");
		this.topics = null;	
		
	}

	public String process() {
		VoteController voteController= this.getControllerFactory().getVoteController();
		return null;
	}

}
