<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page d'administrateur</title>
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

<h1 style="text-align: center; margin-top: 50px">Page d'administrateur</h1>
<br/>
<div class="center">
    <p>Bienvenue sur la page d'administrateur. Ici, vous pouvez gérer les utilisateurs, les annonces, et d'autres fonctionnalités spécifiques à l'administrateur.</p>
    <!-- Ajoutez vos liens et fonctionnalités d'administrateur ici -->
    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/utilisateur/listeAnnoncesAdmin"
           style="text-decoration:none; color: black">Liste des annonces</a>
    </button>

<%--    <button type="button" style="margin: auto; background-color: #F3d4b0" class="btn btn">--%>
<%--        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/creationAnnonce/creerannonce"--%>
<%--           style="text-decoration:none; color: black">Créer une annonce</a>--%>
<%--    </button>--%>
    <br>
    <br>
    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/listeannoncesignalee"
           style="text-decoration:none; color: black">Liste des annonces signalees</a>
    </button>

    <%--    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">
            <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/addannoncesignalee"
               style="text-decoration:none; color: black">Créer une annonce signalee</a>
        </button>--%>
    <br>
    <br>
    <button type="button"  class="btn btn" style="margin: auto; background-color: #F3d4b0 ">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/listeMessagerie"
           style="text-decoration:none; color: black">Liste des messages</a>
    </button>

<%--    <button type="button"  class="btn btn" style="margin: auto; background-color: #F3d4b0 ">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/addmessagerie"
           style="text-decoration:none; color: black">Créer une messagerie</a>
    </button>--%>
    <br>
    <br>
    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/listeEspece"
           style="text-decoration:none; color: black">Liste des especes</a>
    </button>
    <br>
    <br>
    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/addespece"
           style="text-decoration:none; color: black">Créer une espece</a>
    </button>
    <br>
    <br>
    <button type="button" style="margin: auto; background-color: #F3d4b0 " class="btn btn">
        <a href="http://localhost:8080/ProjetRobillardMonizHou_war_exploded/utilisateur/listeUtilisateurs"
           style="text-decoration:none; color: black">Liste des utilisateurs</a>
    </button>

</div>
</body>
</html>
