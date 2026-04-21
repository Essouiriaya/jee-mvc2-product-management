package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("logout".equals(action)) {
            HttpSession session = req.getSession(false);

            if (session != null) {
                session.invalidate();
            }

            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("login".equals(action)) {

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            HttpSession session = req.getSession();

            if ("admin".equals(username) && "admin123".equals(password)) {

                session.setAttribute("user", username);
                session.setAttribute("role", "ADMIN");
                System.out.println("LOGIN SUCCESS");

                resp.sendRedirect(req.getContextPath() + "/produit?action=list");

            } else if ("user".equals(username) && "user123".equals(password)) {

                session.setAttribute("user", username);
                session.setAttribute("role", "USER");
                System.out.println("LOGIN SUCCESS");
                System.out.println("SESSION ID LOGIN = " + session.getId());

                resp.sendRedirect(req.getContextPath() + "/produit?action=list");

            } else {
                resp.sendRedirect(req.getContextPath() + "/login.jsp?error=true");
            }
        }
    }
}