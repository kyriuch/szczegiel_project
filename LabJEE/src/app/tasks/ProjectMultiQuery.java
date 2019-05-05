package app.tasks;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Project;
import app.model.Task;
import app.util.HibernateUtil;
import sun.security.ssl.Debug;

/**
 * Servlet implementation class ProjectMultiQuery
 */
@WebServlet("/ProjectMultiQuery")
public class ProjectMultiQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectMultiQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

		List<Object[]> results = entityManager.createNativeQuery("SELECT project_id, name FROM project")
				.getResultList();
		
		for (Object[] objects : results) {
			Integer projektId = (Integer) objects[0];
			String nazwa = (String) objects[1];
			System.out.println("ID: " + projektId + ", NAZWA: " + nazwa);
		}

		entityManager.close();
	}

}
