<%@ page import="cgodin.models.entities.Utilisateur" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des utilisateurs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <style>
        .center {
            margin: auto;
            width: 60%;
        }
    </style>
</head>
<body>

<div class="center">
    <h1 class="center">Liste des utilisateurs</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Courriel</th>
        <th>Lieu de résidence</th>
        <th>Numéro de téléphone</th>
        <th>Mot de passe</th>
        <th>Compte actif</th>
    </tr>
    </thead>
    <tbody>
    <% List<Utilisateur> utilisateurs = (List<Utilisateur>)request.getAttribute("utilisateurs"); %>
<%--    <% for (Utilisateur utilisateur : utilisateurs) { %>--%>
<%--    <tr>--%>
<%--        <td><%= utilisateur.getIdMembre() %></td>--%>
<%--        <td><%= utilisateur.getNom() %></td>--%>
<%--        <td><%= utilisateur.getPrenom() %></td>--%>
<%--        <td><%= utilisateur.getCourriel() %></td>--%>
<%--        <td><%= utilisateur.getLieuResidence() %></td>--%>
<%--        <td><%= utilisateur.getNoTelephone() %></td>--%>
<%--        <td><%= utilisateur.getMotDePasse() %></td>--%>
<%--        <td><%= utilisateur.isCompteEstActif() %></td>--%>
<%--&lt;%&ndash;        <td> <input type="submit" value="Supprimer le compte" class="btn btn" style="margin: auto; background-color: #F3d4b0; margin: 20px "/></td>&ndash;%&gt;--%>
<%--        <td>--%>
<%--&lt;%&ndash;            <form method="post" action="${pageContext.request.contextPath}/utilisateur/deleteProfile">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="hidden" name="idMembre" value="<%= utilisateur.getIdMembre() %>">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <button type="submit" class="btn btn" style="margin: auto; background-color: #F3d4b0; margin: 20px "                  >Supprimer le compte</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </form>&ndash;%&gt;--%>
<%--    <a href="../utilisateur/desactiverUtilisateur?id=${utilisateur.idMembre}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Desactiver utilisateur</button></a>--%>
<%--        </td>--%>

<%--    </tr>--%>
<%--    <% } %>--%>
    <% for (Utilisateur utilisateur : utilisateurs) { %>
    <tr>
        <td><%= utilisateur.getIdMembre() %></td>
        <td><%= utilisateur.getNom() %></td>
        <td><%= utilisateur.getPrenom() %></td>
        <td><%= utilisateur.getCourriel() %></td>
        <td><%= utilisateur.getLieuResidence() %></td>
        <td><%= utilisateur.getNoTelephone() %></td>
        <td><%= utilisateur.getMotDePasse() %></td>
        <td><%= utilisateur.isCompteEstActif() %></td>
        <td>
            <form method="post" action="${pageContext.request.contextPath}/utilisateur/supprimerUtilisateur">
                <input type="hidden" name="id" value="<%= utilisateur.getIdMembre() %>">
                <button type="submit" class="btn btn" style="margin: auto; background-color: #F3d4b0 ">Désactiver le compte</button>
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</div>
</body>
</html>
