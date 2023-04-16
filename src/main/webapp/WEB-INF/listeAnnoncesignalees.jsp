<%@ page import="cgodin.models.entities.Annonce" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>listeAnnoncesignalees - SOS Animal</title>
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
<h1 style="text-align: center; margin-top: 50px">Liste Annonce signalees</h1>
<br/>
<div class="center">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">AnnonceIDAnnonce</th>
            <th scope="col">UtilisateurIDMembre</th>
            <th scope="col">Date Signalement</th>
            <th scope="col">Notes</th>
            <th scope="col">Type</th>
            <th scope="col">Action</th>

        </tr>
        </thead>
        <tbody>
            <c:forEach var="annonce_signalee" items="${annonce_signalees}">
            <tr>
                <td>${annonce_signalee.annonceIDAnnonce}</td>
                <td>${annonce_signalee.utilisateurIDMembre}</td>
                <td>${annonce_signalee.dateSignalement}</td>
                <td>${annonce_signalee.notes}</td>
                <td>${annonce_signalee.type}</td>
                <td><a href="getSignaleeDetail?id1=${annonce_signalee.annonceIDAnnonce}&id2=${annonce_signalee.utilisateurIDMembre}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Détail</button></a></td>

            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
