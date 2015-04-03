package views.beans;


public class DeleteTopicBean extends ListTopicsBean{

	private static final long serialVersionUID = 7389408341421311664L;
	private String token;
	private Integer topicId;
	private boolean authorized = false;


	public DeleteTopicBean() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token=token;
	}

	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String process() {
		if(token == null && topicId != null){
			this.getControllerFactory().getDeleteTopicController().deleteTopic(topicId);
		}else if(token != null && !token.equals("")){
			authorized = this.getControllerFactory().getDeleteTopicController().authorize(token);
		}
		return "DeleteTopic";
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

	@Override
	public void dataUpdate() {
		// TODO Auto-generated method stub
		
	}
	
}
