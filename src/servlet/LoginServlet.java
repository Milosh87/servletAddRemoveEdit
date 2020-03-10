package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import user.User;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
      
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =  request.getParameter("user");
		String password =  request.getParameter("pass");
//
		User newUser = new User(username,password);
		
		List<User> users = (List<User>) request.getServletContext().getAttribute("users");

		
		if(users.contains(newUser)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", newUser);
			session.setAttribute("logged", "logged in as: " + newUser.getUsername());
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/home.jsp");
			rd.forward(request, response);
		}
	else {
		request.setAttribute("error", "user doesn't exist");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.invalidate();
		resp.sendRedirect("login.jsp");
	}

}
