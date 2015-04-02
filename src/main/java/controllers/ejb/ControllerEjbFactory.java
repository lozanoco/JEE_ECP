package controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controllers.AddTopicController;
import controllers.ControllerFactory;
import controllers.VoteController;

@ManagedBean(name = "controllerEJBFactory")
@ApplicationScoped
public class ControllerEjbFactory extends ControllerFactory {


    private VoteController voteController;
    
    private AddTopicController addTopicController;


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

}
