package app.tasks;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Project;
import app.util.HibernateUtil;
import sun.security.ssl.Debug;

/**
 * Servlet implementation class ProjektDelete
 */
@WebServlet("/ProjektDelete")
public class ProjektDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjektDelete() {
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
		
		String projectIdParam = request.getParameter("project_id");
		Debug.println("EHEH", projectIdParam);
		
		if(request.getParameter("btn_usun") != null
				&& projectIdParam != null) {
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
			
			int projectId = Integer.parseInt(projectIdParam);
			
			Project project = entityManager.find(Project.class, projectId);
			
			request.setAttribute("project_name", project.getName());
			
			entityManager.getTransaction().begin();
			entityManager.remove(project);
			entityManager.getTransaction().commit();
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/projekt_delete.jsp");
		dispatcher.forward(request, response);
	}

}
