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
import app.util.HibernateUtil;
import sun.security.ssl.Debug;

/**
 * Servlet implementation class ProjektList
 */
@WebServlet("/ProjektList")
public class ProjektList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjektList() {
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
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

		StringBuilder queryBuilder = new StringBuilder();

		queryBuilder.append("SELECT p FROM Project p");

		boolean isFromButton = request.getParameter("btn_list") != null;

		if (isFromButton) {
			String projectId = request.getParameter("project_id");

			boolean whereAdded = false;

			if (projectId != null && !projectId.isEmpty()) {
				try {
					Integer pId = Integer.parseInt(projectId);

					queryBuilder.append(" WHERE p.projectId = ");
					queryBuilder.append(pId);
					whereAdded = true;
				} catch (Exception e) {

				}
			}

			String projectName = request.getParameter("project_name");

			if (projectName != null && !projectName.isEmpty()) {
				if (!whereAdded)
					queryBuilder.append(" WHERE ");

				queryBuilder.append("p.name LIKE '%");
				queryBuilder.append(projectName);
				queryBuilder.append("%'");
			}
		}

		TypedQuery<Project> query = entityManager.createQuery(queryBuilder.toString(), Project.class);

		if(isFromButton) {
			String limit = request.getParameter("list_count");

			if (limit != null && !limit.isEmpty()) {
				try {
					Integer lim = Integer.parseInt(limit);

					query.setMaxResults((lim + 1) * 5);
				} catch (Exception e) {

				}
			}
		}
		

		List<Project> projects = query.getResultList();
		request.setAttribute("projects", projects);

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/projects_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}