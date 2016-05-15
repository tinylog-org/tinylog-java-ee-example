package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.h2.tools.RunScript;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Logger;

@WebListener
public class LifeCycleListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		/* Load driver for Apache Tomcat */
		new org.h2.Driver();

		/* Create tables */
		try (InputStream stream = LifeCycleListener.class.getClassLoader().getResourceAsStream("database.sql")) {
			try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:DEMO;DB_CLOSE_DELAY=-1")) {
				RunScript.execute(connection, new InputStreamReader(stream));
			} catch (SQLException ex) {
				Logger.error(ex);
			}
		} catch (IOException ex) {
			Logger.error(ex);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		Configurator.shutdownWritingThread(false);
	}

}
