package security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("admin123")) {

            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", "ADMIN");

            resp.sendRedirect("listProduits");

        } else if (username.equals("user") && password.equals("user123")) {

            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", "USER");

            resp.sendRedirect("listProduits");

        } else {

            resp.sendRedirect("login.jsp?error=true");

        }
    }
}