package app.tasks;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Project;
import app.model.Task;
import app.util.HibernateUtil;

/**
 * Servlet implementation class TasksList
 */
@WebServlet("/TasksList")
public class TasksList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TasksList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

		StringBuilder queryBuilder = new StringBuilder();
		int projectId = Integer.valueOf(request.getParameter("id"));
		
		queryBuilder.append("SELECT t FROM Task t ");
		queryBuilder.append("WHERE t.projectId = ");
		queryBuilder.append(projectId);
		queryBuilder.append("ORDER BY t.order");
		
		TypedQuery<Task> query = entityManager.createQuery(queryBuilder.toString(), Task.class);
		
		List<Task> tasks = query.getResultList();
		request.setAttribute("tasks", tasks);

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/tasks_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
