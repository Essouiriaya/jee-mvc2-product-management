package filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        String uri = req.getRequestURI();

        if (uri.contains("login.jsp") || uri.contains("login")) {

            chain.doFilter(request, response);
            return;

        }

        if (session != null && session.getAttribute("user") != null) {

            chain.doFilter(request, response);

        } else {

            resp.sendRedirect("login.jsp");

        }
    }
}