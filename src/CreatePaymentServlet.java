import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.commpayment.Payment;
import mysql.commpayment.PaymentET;
 
@WebServlet("/createPayment")
public class CreatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/createPayment.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            String phoneNumber = request.getParameter("phoneNumber");
            int total = Integer.parseInt(request.getParameter("total"));
            Payment payment = new Payment(phoneNumber, total);
            PaymentET.addNew(payment);
            response.sendRedirect(request.getContextPath()+"/payment");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/createPayment.jsp").forward(request, response); 
        }
    }
}