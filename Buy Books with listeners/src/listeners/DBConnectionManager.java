package listeners;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.DBUtils;

/**
 * Application Lifecycle Listener implementation class DBConnectionManager
 *
 */
@WebListener //To tell WC following class is web app listener
public class DBConnectionManager implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("in ctx destroyed");
		// close singleton instance of DB connection
		try {
			DBUtils.cleanUp();
		} catch (SQLException e) {
			System.out.println("err in ctx destroyed "+e);
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// get servlet ctx from servlet ctx event
		ServletContext ctx = sce.getServletContext();
		// create singleton instance of DB connection
		System.out.println("in ctx inited");
		// invoke DBUtils method
		try {
			DBUtils.createSingletonConnection(ctx.getInitParameter("drvr_cls"), ctx.getInitParameter("db_url"),
					ctx.getInitParameter("user_nm"), ctx.getInitParameter("password"));
		} catch (Exception e) {
			//System.out.println("Error in ctx inited " + e);
			e.printStackTrace();
		}

	}

}
