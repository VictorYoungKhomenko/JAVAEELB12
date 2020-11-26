import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.commpayment.Service;
import mysql.commpayment.ServiceET;
 
@WebServlet("/createService")
public class CreateServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/createService.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            int rate = Integer.parseInt(request.getParameter("rate"));
            Service service = new Service(name, rate);
            ServiceET.addNew(service);
            response.sendRedirect(request.getContextPath()+"/service");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/createService.jsp").forward(request, response); 
        }
    }
}