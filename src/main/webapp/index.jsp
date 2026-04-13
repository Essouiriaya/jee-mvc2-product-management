<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Gestion des Produits MVC1</title>
</head>

<body>

<h2>Gestion des Produits (MVC1)</h2>

<p>
Utilisateur connecté : <b>${sessionScope.user}</b> |
Rôle : <b>${sessionScope.role}</b> |
<a href="logout">Logout</a>
</p>

<hr/>

<form action="${produitEdit != null ? 'updateProduit' : 'addProduit'}" method="post">

<input type="hidden" name="idProduit" value="${produitEdit.idProduit}" />

Nom : <input type="text" name="nom" value="${produitEdit.nom}" required />
Description : <input type="text" name="description" value="${produitEdit.description}" required />
Prix : <input type="text" name="prix" value="${produitEdit.prix}" required />
<input type="submit" value="${produitEdit != null ? 'Modifier' : 'Ajouter'}" />

</form>

<hr/>

<form action="listProduits" method="get">

ID : <input type="text" name="idProduit" />

<input type="submit" value="Rechercher" />

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

<c:forEach var="p" items="${listeProduits}">

<tr>

<td>${p.idProduit}</td>
<td>${p.nom}</td>
<td>${p.description}</td>
<td>${p.prix}</td>

<td>

<a href="editProduit?id=${p.idProduit}">Modifier</a>

<c:if test="${sessionScope.role == 'ADMIN'}">

| <a href="deleteProduit?id=${p.idProduit}"
onclick="return confirm('Voulez-vous vraiment supprimer ce produit ?');">

Supprimer

</a>

</c:if>

</td>

</tr>

</c:forEach>

</table>

</body>
</html>
