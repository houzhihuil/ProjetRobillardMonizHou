<%@ page import="cgodin.models.entities.Annonce" %>
<%@ page import="cgodin.models.DAO.AnnonceDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
    <title>Liste des Annonces - SOS Animal</title>
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
<%
    AnnonceDAO annonceDAO = new AnnonceDAO();
    List<Annonce> annonces = annonceDAO.annoncesByUtilisateurIDMembre((int) session.getAttribute("userID"));
%>
<div class="center">
<h1 style="text-align: center; margin-top: 50px">Mes annonces</h1>
<br/>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Photo</th>
        <th scope="col">Type</th>
        <th scope="col">Date</th>
        <th scope="col">Localisation</th>
        <th scope="col">Espèce</th>
        <th scope="col">Sexe</th>
        <th scope="col">Notes</th>
        <th scope="col">Active</th>
        <th scope="col">Espece Nom</th>
        <th scope="col">ID Membre</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="annonce" items="${annonces}">
        <tr>
            <td>${annonce.idAnnonce}</td>
            <td>
                <!-- Display the photo using the <img> tag -->
                <img src="${annonce.photoURL}" alt="Annonce Photo" width="100" />
            </td>
            <td>${annonce.typeAnnonce}</td>
            <td>${annonce.date}</td>
            <td>${annonce.localisation}</td>
            <td>${annonce.espece}</td>
            <td>${annonce.sexe}</td>
            <td>${annonce.notes}</td>
            <td>${annonce.annonceEstActive}</td>
            <td>${annonce.especeNom}</td>
            <td>${annonce.utilisateurIDMembre}</td>
             <td><a href="../utilisateur/showAnnonceForm?id=${annonce.idAnnonce}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Modifier annonce</button></a></td>
            <td><a href="../creationAnnonce/desactivaterAnnonce?id=${annonce.idAnnonce}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Desactiver annonce</button></a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
