import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.commpayment.Payment;
import mysql.commpayment.PaymentET;

@WebServlet("/editPayment")
public class PaymentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Payment payment = PaymentET.chooseThis(id);
            if(payment!=null) {
                request.setAttribute("payment", payment);
                getServletContext().getRequestDispatcher("/editPayment.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String phoneNumber = request.getParameter("phoneNumber");
            int total = Integer.parseInt(request.getParameter("total"));
            Payment payment = new Payment(id, phoneNumber, total);
            PaymentET.change(payment);
            response.sendRedirect(request.getContextPath() + "/payment");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
        }
    }
}