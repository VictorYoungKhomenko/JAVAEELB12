import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
  
@WebServlet("/setSession")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        PrintWriter out = response.getWriter();
        try {
            if(name == null) {
                session.setAttribute("name", "Victor Khomenko");
                out.println("Session data are set");
            }
            else {
                out.println("Name: " + name);
                session.removeAttribute("name");
            }
        }
        finally {
            out.close();
        }
    }
}