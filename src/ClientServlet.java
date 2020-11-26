import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.commpayment.Client;
import mysql.commpayment.ClientET;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayList<Client> clients = ClientET.choose();
        request.setAttribute("clients", clients);
          
        getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
    }
}