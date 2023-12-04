package semestarovka.listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import semestarovka.reposetories.Fileservice;
import semestarovka.reposetories.Filesrepo;
import semestarovka.reposetories.Userrepo;
import semestarovka.reposetories.implementations.FileServiceImplementations;
import semestarovka.reposetories.implementations.FilesRepositoryJdbcImpl;
import semestarovka.reposetories.implementations.UserRepositoryJdbcimplementations;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomServletContextListener implements ServletContextListener {

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "#llj1234";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/STEVEN_GRAND";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);

        ServletContext servletContext = servletContextEvent.getServletContext();

        Userrepo accountsRepository = new UserRepositoryJdbcimplementations(dataSource);
        servletContext.setAttribute("accountRep", accountsRepository);
        Filesrepo filesrepo= new FilesRepositoryJdbcImpl(dataSource);
        servletContext.setAttribute("files",filesrepo);

        Fileservice fileservice = new FileServiceImplementations(dataSource);
        servletContext.setAttribute("fileservice", fileservice);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // Cleanup code if needed
    }
}