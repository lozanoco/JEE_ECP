package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.beans.VoteBean;

/**
 * Servlet implementation class Hello_servlet
 */
@WebServlet(urlPatterns={"/jsp/*"})
public class JpaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String PATH_ROOT_VIEW = "/views/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JpaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "home";
		switch (action) {
		case "Vote":
			VoteBean voteBean = new VoteBean();
			request.setAttribute(action, voteBean);
            view = action;
			break;
			//		case "ViewVotes":
			//			ViewVotesBean verVotacionesBean = new ViewVotesBean();
			//
			//			break;
			//		case "AddTopic":
			//			AddTopicBean aniadirTemaBean = new AddTopicBean();
			//
			//			break;
			//		case "DeleteTema":
			//			DeleteTopicBean eliminarTemaBean = new DeleteTopicBean();
			//
			//			break;
		default:
			view = "home";
		}
		 this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
         .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/JEE_ECP/jsp/home con metodo Post");
	}

}
