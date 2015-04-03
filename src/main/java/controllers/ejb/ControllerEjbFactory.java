package controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controllers.AddTopicController;
import controllers.ControllerFactory;
import controllers.DeleteTopicController;
import controllers.ViewVoteController;
import controllers.VoteController;

@ManagedBean(name = "controllerEJBFactory")
@ApplicationScoped
public class ControllerEjbFactory extends ControllerFactory {


    private VoteController voteController;
    
    private AddTopicController addTopicController;
    
    private DeleteTopicController deleteTopicController;
    
    private ViewVoteController viewVoteController;


	@Override
	public VoteController getVoteController() {
		if (this.voteController == null) {
            this.voteController = new VoteEjbController();
        }
        return voteController;
	}


	@Override
	public AddTopicController getAddTopicController() {
		if (this.addTopicController == null) {
            this.addTopicController = new AddTopicEjbController();
        }
        return addTopicController;
	}


	@Override
	public DeleteTopicController getDeleteTopicController() {
		if (this.deleteTopicController == null) {
            this.deleteTopicController = new DeleteTopicEjbController();
        }
        return deleteTopicController;
	}


	@Override
	public ViewVoteController getViewVoteController() {
		if (this.viewVoteController == null) {
            this.viewVoteController = new viewVoteEjbController();
        }
        return viewVoteController;
	}

}
