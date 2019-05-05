package app.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import app.util.HibernateUtil;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getInstance().closeEntityManagerFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getInstance().createEntityManagerFactory();
	}
}
