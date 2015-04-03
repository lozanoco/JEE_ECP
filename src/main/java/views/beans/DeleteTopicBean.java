package views.beans;

public class DeleteTopicBean extends GenericBean{

	private static final long serialVersionUID = 1L;

	private String token;
	private Integer topicId;


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
		}
		return token;
	}
}
