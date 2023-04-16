<%@ page import="cgodin.models.entities.Utilisateur" %>
<%@ page import="java.util.List" %>
<%@ page import="cgodin.models.DAO.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style>
        .nav-link:hover {
            font-weight: bold; /* gras quand survolle */
        }

        #table {
            margin: auto;
            width: 60%;
        }

        .center {
            margin: auto;
            width: 60%;
        }

        input {
            background-color: chocolate;
        }
    </style>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</head>
<body>
<!-- Add the success message block here -->
<div class="container">
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success" role="alert">
                ${successMessage}
        </div>
    </c:if>
</div>

<nav class="navbar navbar-expand-lg" style="text-align: center; background-color: #9DC4BC; padding: 20px;>
    <a class=" class="navbar-brand" href="#">



    <a class="navbar-brand" href="#" style="font-size: 30px; display: flex; align-items: center;">
        <div style="border-radius: 50%; overflow: hidden; height: 80px; width: 80px;">
            <img src="<c:url value='/images/logo.png'/>" alt="Logo" style="height: 100%; width: 100%;">
        </div>
        <span style="margin-left: 10px;">SOS Animal</span>
    </a>


    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/utilisateur/editProfile"
                       style="text-decoration:none; color: black">Modifier compte</a>
            </li>
            <li class="nav-item">
<%--                <a class="nav-link" href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/listeMessagerie"--%>
<%--                   style="text-decoration:none; color: black">Messagerie</a>--%>
                <a class="nav-link" href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/listeMesMessagerie"
                   style="text-decoration:none; color: black">Messagerie</a>
            </li>

        </ul>
    </div>
</nav>

<div style="text-align: center;  padding: 20px; border: solid 2px white; margin: 100px">

    <div style="float: left;">
        <img src="<c:url value='/images/chienperdu.jpg'/>" alt="Chien perdu" style="width: 950px; height: 534px;" />
    </div>

<%--    <p>Bonjour ${utilisateur.prenom}. Votre no d'identifiant est le ${utilisateur.idMembre}. Vous êtes connectés.</p>--%>
    <p>Bonjour ${utilisateur.prenom}. Vous êtes connecté.</p>
    <br>
    <br>


    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/utilisateur/listeAnnonce"
           style="text-decoration:none; color: black">Liste des annonces</a>
    </button>
    <br>
    <br>
    <br>
    <br>
    <button type="button" style="margin: auto; background-color: #F3d4b0" class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/creationAnnonce/creerannonce"
           style="text-decoration:none; color: black">Créer une annonce</a>
    </button>
    <br>
    <br>
    <br>
    <br>
<%--    <button type="button"  class="btn btn" style="margin: auto; background-color: #F3d4b0 ">--%>
<%--        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/listeMesMessagerie"--%>
<%--           style="text-decoration:none; color: black">Liste des mes messageries</a>--%>
<%--    </button>--%>

    <%--<button type="button"  class="btn btn" style="margin: auto; background-color: #F3d4b0 ">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/addmessagerie"
           style="text-decoration:none; color: black">Créer un message</a>
    </button>--%>
    <button type="button" style="margin: auto; background-color: #F3d4b0" class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/utilisateur/listeMesAnnonces"
           style="text-decoration:none; color: black">Mes annonces</a>
    </button>
    <br>
    <br>
    <br>
    <br>
<%--    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">--%>
<%--        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/listeannoncesignalee"--%>
<%--           style="text-decoration:none; color: black">Liste des annonces signalees</a>--%>
<%--    </button>--%>

<%--    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/addannoncesignalee"
           style="text-decoration:none; color: black">Créer une annonce signalee</a>
    </button>--%>

</div>



<script>
    document.addEventListener("DOMContentLoaded", function () {
        const successMessage = "${successMessage}";
        if (successMessage) {
            // Remove the success message from the session after displaying it
            <c:set var="successMessage" scope="session" value=""/>
        }
    });
</script>
</body>
</html>


