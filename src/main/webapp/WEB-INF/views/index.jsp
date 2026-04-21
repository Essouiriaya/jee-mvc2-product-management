<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gestion des Produits</title>
</head>

<body>

<h1>Gestion des Produits (MVC2)</h1>

<p>
    Utilisateur : <b>${sessionScope.user}</b> |
    Rôle : <b>${sessionScope.role}</b> |
    <a href="auth?action=logout">Logout</a>
</p>

<hr/>

<h3>Recherche par ID</h3>

<form action="produit" method="get">

    <input type="hidden" name="action" value="searchById"/>

    ID :
    <input type="number" name="id" required />

    <input type="submit" value="Chercher" />

</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<hr/>

<h3>
    <c:choose>
        <c:when test="${formAction == 'update'}">Modifier Produit</c:when>
        <c:otherwise>Ajouter Produit</c:otherwise>
    </c:choose>
</h3>

<form action="produit" method="post">

    <input type="hidden" name="action"
           value="${empty formAction ? 'add' : formAction}" />

    <input type="hidden" name="id"
           value="${produit != null ? produit.id : ''}" />

    Nom :
    <input type="text" name="nom"
           value="${produit != null ? produit.nom : ''}"
           required />

    Description :
    <input type="text" name="description"
           value="${produit != null ? produit.description : ''}"
           required />

    Prix :
    <input type="number" step="0.01" name="prix"
           value="${produit != null ? produit.prix : ''}"
           required />

    <input type="submit"
           value="${formAction == 'update' ? 'Modifier' : 'Ajouter'}" />

    <input type="reset" value="Vider" />

</form>

<hr/>

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
                       onclick="return confirm('Supprimer ?');">
                        Supprimer
                    </a>
                </c:if>

            </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>