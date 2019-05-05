package app.tasks;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Project;
import app.util.HibernateUtil;
import sun.security.ssl.Debug;

/**
 * Servlet implementation class ProjektSingleQuery
 */
@WebServlet("/ProjektSingleQuery")
public class ProjektSingleQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjektSingleQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManager entityManger = HibernateUtil.getInstance().createEntityManager();
		
		TypedQuery<Project> query = entityManger.createQuery("SELECT p FROM Project p WHERE p.projectId = 5", Project.class);
		Project project = query.getSingleResult();
		if(project != null) {
			Debug.println("PROJECT", "Project id = 1" + project.getName());
		}
	}

}
