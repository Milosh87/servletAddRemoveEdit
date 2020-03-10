package listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import city.City;
import user.User;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	List<User> users = new ArrayList<>();
    	users.add(new User("milos", "123"));
    	arg0.getServletContext().setAttribute("users", users);
    	
    	List<City> cities = new ArrayList<>();
    	cities.add(new City("Beograd", 11000));
    	cities.add(new City("Novi Sad", 13000));
    	arg0.getServletContext().setAttribute("cities", cities);
    }
	
}
