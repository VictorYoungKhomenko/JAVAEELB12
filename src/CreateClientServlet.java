import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.commpayment.Client;
import mysql.commpayment.ClientET;
 
@WebServlet("/createClient")
public class CreateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/createClient.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            String firstName = request.getParameter("firstName");
            String phoneNumber = request.getParameter("phoneNumber");
            Client client = new Client(firstName, phoneNumber);
            ClientET.addNew(client);
            response.sendRedirect(request.getContextPath()+"/client");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/createClient.jsp").forward(request, response); 
        }
    }
}