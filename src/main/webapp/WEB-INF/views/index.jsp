<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gestion des Produits MVC2</title>
</head>

<body>

<h2>Gestion des Produits (MVC2 Single Page)</h2>

<p>
Utilisateur connecté : <b>${sessionScope.user}</b> |
Rôle : <b>${sessionScope.role}</b> |
<a href="auth?action=logout">Logout</a>
</p>

<hr/>

<!-- ================= LIST MODE ================= -->
<c:if test="${mode == 'list'}">

    <a href="produit?action=addForm">➕ Ajouter nouveau produit</a>

    <table border="1" cellpadding="5">

        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="p" items="${produits}">

            <tr>

                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.description}</td>
                <td>${p.prix}</td>

                <td>

                    <a href="produit?action=editForm&id=${p.id}">
                        Modifier
                    </a>

                    <c:if test="${sessionScope.role == 'ADMIN'}">
                        |
                        <a href="produit?action=delete&id=${p.id}"
                           onclick="return confirm('Supprimer ce produit ?');">
                            Supprimer
                        </a>
                    </c:if>

                </td>

            </tr>

        </c:forEach>

    </table>

</c:if>

<!-- ================= FORM MODE ================= -->
<c:if test="${mode == 'form'}">

    <form action="produit" method="post">

        <input type="hidden" name="action" value="${formAction}" />
        <input type="hidden" name="id" value="${produit.id}" />

        Nom :
        <input type="text" name="nom"
               value="${produit.nom}" required /><br/>

        Description :
        <input type="text" name="description"
               value="${produit.description}" required /><br/>

        Prix :
        <input type="text" name="prix"
               value="${produit.prix}" required /><br/>

        <input type="submit"
               value="${formAction == 'update' ? 'Modifier' : 'Ajouter'}" />

    </form>

</c:if>

<hr/>

<a href="produit?action=list">🔄 Refresh</a>

</body>
</html>