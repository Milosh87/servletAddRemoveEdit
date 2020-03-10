package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import city.City;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/city")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "";
		if (request.getParameter("operation").equals("all")) {
			page = "WEB-INF/pages/allcities.jsp";

		} else if (request.getParameter("operation").equals("new")) {
			page = "WEB-INF/pages/newcity.jsp";
		} else if (request.getParameter("operation").equals("back")) {
			page = "WEB-INF/pages/home.jsp";
		} else if (request.getParameter("operation").equals("remove")) {
			removeCity(request, response);
			return;
		} else if (request.getParameter("operation").equals("edit")) {
			request.setAttribute("ptt", (String) request.getParameter("ptt"));
			request.setAttribute("ime", (String) request.getParameter("ime"));
			page = "WEB-INF/pages/editCity.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	private void removeCity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/allcities.jsp");
		List<City> cities = (List<City>) request.getServletContext().getAttribute("cities");
		City removeCity = new City();
		removeCity.setPostanskiBroj(Integer.parseInt(request.getParameter("ptt")));
		cities.remove(removeCity);
		request.getServletContext().setAttribute("cities", cities);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("hidden").equals("edit")) {
			edit(req, resp);

		} else {
			newCity(req, resp);
		}

	}

	private void newCity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ime = req.getParameter("ime");
		boolean signal = true;
		int pttBroj = 0;
		try {
			pttBroj = Integer.parseInt(req.getParameter("ptt"));
		} catch (Exception e) {
			signal = false;
			req.setAttribute("ime", req.getParameter("ime"));
			req.setAttribute("ptt", req.getParameter("ptt"));
			req.setAttribute("error", "Ptt: Not a number!");
		}

		if (signal) {
			City city = new City(ime, pttBroj);
			List<City> cities = (List<City>) req.getServletContext().getAttribute("cities");
			if (!cities.contains(city)) {
				cities.add(city);
				req.getServletContext().setAttribute("cities", cities);
				RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/home.jsp");
				rd.forward(req, resp);
				return;
			} else {
				req.setAttribute("ime", req.getParameter("ime"));
				req.setAttribute("ptt", req.getParameter("ptt"));
				req.setAttribute("error", "City already exists");

			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/newcity.jsp");

		rd.forward(req, resp);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ime = req.getParameter("editovanoIme");
		int ptt = Integer.parseInt(req.getParameter("ptt"));
		List<City> cities = (List<City>) req.getServletContext().getAttribute("cities");
		for (City c : cities) {
			if (c.getPostanskiBroj() == ptt) {
				c.setIme(ime);
			}
		}
		req.getServletContext().setAttribute("cities", cities);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/allcities.jsp");
		rd.forward(req, resp);
	}

}
