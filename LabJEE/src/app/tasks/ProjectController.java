package app.tasks;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Project;
import app.util.HibernateUtil;

/**
 * Servlet implementation class ProjectController
 */
@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Project p = new Project();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("delete"))
		{
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();		
			
			int id = Integer.valueOf(request.getParameter("id"));
			Project project = entityManager.find(Project.class, id);
			
			entityManager.getTransaction().begin();
			entityManager.remove(project);
			entityManager.getTransaction().commit();
			
			System.out.println("Usuwam projekt id= " + id);
			request.getRequestDispatcher("ProjektList").forward(request, response);
		}
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("add"))
		{
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
			
			Project project = new Project();
			project.setName(request.getParameter("nazwa"));
			project.setDescription(request.getParameter("opis"));
			project.setCreationDate(LocalDateTime.now());
			
			String str = request.getParameter("data_obrony"); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
			LocalDate dateTime = LocalDate.parse(str, formatter);
			project.setReturnDate(dateTime);
			
			entityManager.getTransaction().begin();
			entityManager.persist(project);
			entityManager.getTransaction().commit();
			entityManager.close();
			request.getRequestDispatcher("ProjektList").forward(request, response);
		}else if(action.equals("edit"))
		{
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
			
			int projectId = Integer.valueOf(request.getParameter("id"));
			Project project = entityManager.find(Project.class, projectId);
			
			request.setAttribute("projekt", project);
			request.getRequestDispatcher("project_edit.jsp").forward(request, response);
		}else if(action.equals("processedit"))
		{
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
			
			int id = Integer.valueOf(request.getParameter("id"));
			Project project = entityManager.find(Project.class, id);
			
			entityManager.getTransaction().begin();
			project.setName(request.getParameter("nazwa"));
			project.setDescription(request.getParameter("opis"));
			
			String str2 = request.getParameter("data_obrony"); 
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
			LocalDate date = LocalDate.parse(str2, formatter2);
			project.setReturnDate(date);
			
			entityManager.getTransaction().commit();
			entityManager.close();
			request.getRequestDispatcher("ProjektList").forward(request, response);
		}
	}
}
