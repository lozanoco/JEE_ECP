package controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controllers.ControllerFactory;
import controllers.VoteController;

@ManagedBean(name = "controllerEJBFactory")
@ApplicationScoped
public class ControllerEjbFactory extends ControllerFactory {


    private VoteController voteController;


	@Override
	public VoteController getVoteController() {
		if (this.voteController == null) {
            this.voteController = new VoteEjbController();
        }
        return voteController;
	}

}
