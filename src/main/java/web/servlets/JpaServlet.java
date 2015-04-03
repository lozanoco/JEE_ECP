package web.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.models.entities.Topic;
import controllers.ControllerFactory;
import controllers.ejb.ControllerEjbFactory;
import views.beans.AddTopicBean;
import views.beans.DeleteTopicBean;
import views.beans.DeleteTopicBeanAuthorization;
import views.beans.ViewVotesBean;
import views.beans.VoteBean;


@WebServlet(urlPatterns={"/jsp/*"})
public class JpaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/views/";
	
	private static String JSP = ".jsp";

	private ControllerFactory controllerFactory;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.controllerFactory = new ControllerEjbFactory();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "Home";
		switch (action) {
		case "Vote":
			VoteBean voteBean = new VoteBean();
			voteBean.setControllerFactory(this.controllerFactory);
			request.setAttribute(action, voteBean);
			view = action;
			break;
		case "ViewVotes":
			ViewVotesBean viewVotesBean = new ViewVotesBean();
			viewVotesBean.setControllerFactory(this.controllerFactory);
			request.setAttribute(action, viewVotesBean);
			view = action;
			break;
		case "AddTopic":
			AddTopicBean addTopicBean = new AddTopicBean();
			addTopicBean.setControllerFactory(this.controllerFactory);
			request.setAttribute(action, addTopicBean);
			view = action;
			break;
		case "DeleteTopic":
			DeleteTopicBean deleteTopicBean = new DeleteTopicBean();
			deleteTopicBean.setControllerFactory(this.controllerFactory);
			request.setAttribute(action, deleteTopicBean);
			view = action;
			break;
		case "DeleteTopicAuthorization":
			view = action;
			break;
		default:
			view = "Home";
		}
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + JSP)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "Home";
		switch (action) {
		case "AddTopic":
			AddTopicBean addTopicBean = new AddTopicBean();
			addTopicBean.setControllerFactory(this.controllerFactory);
			String name = request.getParameter("name");
			String question = request.getParameter("question");
			addTopicBean.setTopic(new Topic(name, question));
			request.setAttribute(action, addTopicBean);
			view = PATH_ROOT_VIEW + addTopicBean.process() + JSP;
			break;
		case "DeleteTopic":
			DeleteTopicBean deleteTopicBean = new DeleteTopicBean();
			deleteTopicBean.setControllerFactory(this.controllerFactory);
			deleteTopicBean.setToken(request.getParameter("token"));
			String topicId = request.getParameter("topic");
			if(topicId != null)
				deleteTopicBean.setTopicId(Integer.parseInt(topicId));
			request.setAttribute(action, deleteTopicBean);
			view =  PATH_ROOT_VIEW + deleteTopicBean.process() + JSP;
			break;	
		case "DeleteTopicAuthorization":
			DeleteTopicBeanAuthorization deleteTopicBeanAuthorization = new DeleteTopicBeanAuthorization();
			deleteTopicBeanAuthorization.setControllerFactory(this.controllerFactory);
			deleteTopicBeanAuthorization.setToken(request.getParameter("token"));
			DeleteTopicBean deleteTopicBean2 = new DeleteTopicBean();
			deleteTopicBean2.setControllerFactory(this.controllerFactory);
			String viewReturn = deleteTopicBeanAuthorization.process();
			view =  PATH_ROOT_VIEW + viewReturn + JSP;
			if(viewReturn.equals("DeleteTopicAuthorization"))request.setAttribute(viewReturn, deleteTopicBeanAuthorization);
			else request.setAttribute(viewReturn, deleteTopicBean2);
			break;
			
		default:
			view = PATH_ROOT_VIEW;
		}
		this.getServletContext().getRequestDispatcher(view)
		.forward(request, response);
	}
}
