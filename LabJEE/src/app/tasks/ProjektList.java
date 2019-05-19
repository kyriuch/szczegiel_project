package app.tasks;

import java.io.IOException;
import java.sql.SQLException;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT p FROM Project p");

		String projectId = request.getParameter("project_id");

		boolean whereAdded = false;

		if (projectId != null && !projectId.isEmpty()) {
			try {
				Integer pId = Integer.parseInt(projectId);

				request.setAttribute("pId", pId);

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

			request.setAttribute("projectName", projectName);

			queryBuilder.append("p.name LIKE '%");
			queryBuilder.append(projectName);
			queryBuilder.append("%'");
		}

		queryBuilder.append(" ORDER BY p.projectId");

		TypedQuery<Project> query = entityManager.createQuery(queryBuilder.toString(), Project.class);

		String pageNumber = request.getParameter("page_number");
		
		if(pageNumber == null || pageNumber.isEmpty())
			pageNumber = "1";
		
		String limit = request.getParameter("list_count");
		
		if(limit == null || limit.isEmpty())
			limit = "0";
		
			
		try {
			Integer pageNum = Integer.parseInt(pageNumber) - 1;
			Integer lim = (Integer.parseInt(limit) + 1) * 5;
			
			if(request.getParameter("next") != null)
				pageNum++;
			else if(request.getParameter("prev") != null)
				pageNum--;
			
			System.out.println(pageNum + " " + lim);
			
			request.setAttribute("page_number", pageNum + 1);
			request.setAttribute("list_count", lim);
			
			query.setFirstResult(pageNum * lim);
			query.setMaxResults(lim);
			List<Project> projects = query.getResultList();
			request.setAttribute("projects", projects);
		} catch(Exception e) {
			
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/projects_list.jsp");
		dispatcher.forward(request, response);
	}
}