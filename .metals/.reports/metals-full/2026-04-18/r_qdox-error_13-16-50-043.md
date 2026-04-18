error id: file:///C:/Users/hp/eclipseJEE/jee-mvc2-product-management/src/main/java/controller/ProduitServlet.java
file:///C:/Users/hp/eclipseJEE/jee-mvc2-product-management/src/main/java/controller/ProduitServlet.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[4,16]

error in qdox parser
file content:
```java
offset: 62
uri: file:///C:/Users/hp/eclipseJEE/jee-mvc2-product-management/src/main/java/controller/ProduitServlet.java
text:
```scala
package controller;

import model.Produit;
import service..@@roduitService;
import service.ProduitServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {

    private ProduitService service = new ProduitServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) action = "list";

        switch (action) {

            case "list":
                List<Produit> produits = service.getAllProduits();
                req.setAttribute("produits", produits);
                req.getRequestDispatcher("views/produits.jsp").forward(req, resp);
                break;

            case "addForm":
                req.getRequestDispatcher("views/addProduit.jsp").forward(req, resp);
                break;

            case "editForm":
                Long id = Long.parseLong(req.getParameter("id"));
                Produit p = service.getProduitById(id);
                req.setAttribute("produit", p);
                req.getRequestDispatcher("views/editProduit.jsp").forward(req, resp);
                break;

            case "delete":
                Long idDel = Long.parseLong(req.getParameter("id"));
                service.deleteProduit(idDel);
                resp.sendRedirect("produit?action=list");
                break;

            default:
                resp.sendRedirect("produit?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action.equals("add")) {

            String nom = req.getParameter("nom");
            String description = req.getParameter("description");
            Double prix = Double.parseDouble(req.getParameter("prix"));

            Produit p = new Produit(nom, description, prix);
            service.addProduit(p);

            resp.sendRedirect("produit?action=list");
        }

        else if (action.equals("update")) {

            Long id = Long.parseLong(req.getParameter("id"));
            String nom = req.getParameter("nom");
            String description = req.getParameter("description");
            Double prix = Double.parseDouble(req.getParameter("prix"));

            Produit p = new Produit(nom, description, prix);
            p.setId(id);

            service.updateProduit(p);

            resp.sendRedirect("produit?action=list");
        }
    }
}
```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1583)
```
#### Short summary: 

QDox parse error in file:///C:/Users/hp/eclipseJEE/jee-mvc2-product-management/src/main/java/controller/ProduitServlet.java