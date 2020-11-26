import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.commpayment.Payment;
import mysql.commpayment.PaymentET;

@WebServlet("/searchPayment")
public class SearchPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchPaymentServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/searchPayment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String phoneNumber = request.getParameter("phoneNumber");
			ArrayList<Payment> payments = PaymentET.findPhoneNumber(phoneNumber);
			if(payments != null) {
		        request.setAttribute("payments", payments);
				getServletContext().getRequestDispatcher("/findPayment.jsp").forward(request, response);
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