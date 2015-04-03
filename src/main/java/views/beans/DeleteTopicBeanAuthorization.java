package views.beans;


public class DeleteTopicBeanAuthorization extends ListTopicsBean{

	private static final long serialVersionUID = 7389408341421311664L;
	private String token;
	private boolean authorized = false;


	public DeleteTopicBeanAuthorization() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token=token;
	}	

	public String process() {
			if(this.getControllerFactory().getDeleteTopicController().authorize(token)){
				return "DeleteTopic";
			}
			return "DeleteTopicAuthorization";		
	}

	public boolean isAuthrorized() {
		return authorized;
	}

	public String getAuthorized() {
		return this.token;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	
}
