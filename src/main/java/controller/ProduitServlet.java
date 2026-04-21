package controller;

import model.Produit;
import service.ProduitServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ProduitServiceImpl service = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // CHECK SESSION
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {

            case "list":
                req.setAttribute("mode", "list");
                req.setAttribute("produits", service.getAllProduits());
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
                break;

            case "addForm":
                req.setAttribute("mode", "form");
                req.setAttribute("formAction", "add");
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
                break;

            case "editForm":
                Long id = Long.parseLong(req.getParameter("id"));

                req.setAttribute("mode", "form");
                req.setAttribute("formAction", "update");
                req.setAttribute("produit", service.getProduitById(id));

                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
                break;

            case "delete":
                Long idDel = Long.parseLong(req.getParameter("id"));
                service.deleteProduit(idDel);

                resp.sendRedirect(req.getContextPath() + "/produit?action=list");
                break;
                
            case "searchById":

                Long id1 = Long.parseLong(req.getParameter("id"));
                Produit p = service.getProduitById(id1);

                req.setAttribute("mode", "list");

                if (p != null) {
                    req.setAttribute("produits", java.util.Arrays.asList(p));
                } else {
                    req.setAttribute("produits", service.getAllProduits());
                    req.setAttribute("error", "Produit introuvable");
                }

                req.getRequestDispatcher("/WEB-INF/views/index.jsp")
                        .forward(req, resp);
                break;
             

            default:
                resp.sendRedirect(req.getContextPath() + "/produit?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("add".equals(action)) {

            Produit p = new Produit(
                    req.getParameter("nom"),
                    req.getParameter("description"),
                    Double.parseDouble(req.getParameter("prix"))
            );

            service.addProduit(p);

        } else if ("update".equals(action)) {

            Produit p = new Produit(
                    req.getParameter("nom"),
                    req.getParameter("description"),
                    Double.parseDouble(req.getParameter("prix"))
            );

            p.setId(Long.parseLong(req.getParameter("id")));
            service.updateProduit(p);
        }

        resp.sendRedirect(req.getContextPath() + "/produit?action=list");
    }
}