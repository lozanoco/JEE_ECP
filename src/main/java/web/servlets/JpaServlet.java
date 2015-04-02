package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello_servlet
 */
@WebServlet(urlPatterns={"/jsp/*"})
public class JpaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
//		String view = "Home";
		if(action.equals("Vote")){	
			String web = "<html><head><title>Vote</title></head>"
	                + "<body> <h1>Entra en voto</h1>" + "</body></html>";
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println(web);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/JEE_ECP/jsp/home con metodo Post");
	}

}
