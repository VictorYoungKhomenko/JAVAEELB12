import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.commpayment.Service;
import mysql.commpayment.ServiceET;

@WebServlet("/searchService")
public class SearchServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchServiceServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/searchService.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int rate = Integer.parseInt(request.getParameter("rate"));
			ArrayList<Service> services = ServiceET.findRate(rate);
			if(services != null) {
		        request.setAttribute("services", services);
				getServletContext().getRequestDispatcher("/findService.jsp").forward(request, response);
			}
			else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
		}
		catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
	}
}