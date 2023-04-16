<%@ page import="cgodin.models.entities.Messagerie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Messagerie - SOS Animal</title>
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
<h1 style="text-align: center; margin-top: 50px">Détail de la messagerie</h1>

<br/>
<div class="center">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">IdMessage</th>
            <th scope="col">Message</th>
            <th scope="col">DateMessage</th>
            <th scope="col">ExpediteurIDMembre</th>
            <th scope="col">DestinataireIDMembre</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${DetailMessagerie.idMessage}</td>
                <td>${DetailMessagerie.message}</td>
                <td>${DetailMessagerie.dateMessage}</td>
                <td>${DetailMessagerie.expediteurIDMembre}</td>
                <td>${DetailMessagerie.destinataireIDMembre}</td>
            </tr>
        </tbody>
    </table>
    <a href="listeMesMessagerie"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Retourner</button></a>
    <td><a href="/ProjetRobillardMonizHou_war_exploded/addmessagerie?id=${DetailMessagerie.expediteurIDMembre}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Répondre</button></a></td>
</div>
</body>
</html>
