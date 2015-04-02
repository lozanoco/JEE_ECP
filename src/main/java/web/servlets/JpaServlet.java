package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
import views.beans.ViewVotesBean;
import views.beans.VoteBean;


@WebServlet(urlPatterns={"/jsp/*"})
public class JpaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/views/";

	private ControllerFactory controllerFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
//	public JpaServlet() {
//		super();
//	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.controllerFactory = new ControllerEjbFactory();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		case "DeleteTema":
			DeleteTopicBean deleteTopicBean = new DeleteTopicBean();
			deleteTopicBean.setControllerFactory(this.controllerFactory);
			request.setAttribute(action, deleteTopicBean);
			view = action;
			break;
		default:
			view = "Home";
		}
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
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
			view = PATH_ROOT_VIEW + addTopicBean.process() + ".jsp";
			break;
		}
		this.getServletContext().getRequestDispatcher(view)
		.forward(request, response);
	}

}
