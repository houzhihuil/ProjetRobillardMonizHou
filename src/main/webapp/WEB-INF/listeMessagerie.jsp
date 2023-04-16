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
<h1 style="text-align: center; margin-top: 50px">Liste des Messagerie</h1>
<br/>
<div class="center">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Message</th>
            <th scope="col">DateMessage</th>
            <th scope="col">ExpediteurIDMembre</th>
            <th scope="col">DestinataireIDMembre</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="messagerie" items="${messageries}">
            <tr>
                <td>${messagerie.idMessage}</td>
                <td>${messagerie.message}</td>
                <td>${messagerie.dateMessage}</td>
                <td>${messagerie.expediteurIDMembre}</td>
                <td>${messagerie.destinataireIDMembre}</td>
                <td><a href="getMessagerieDetail?id=${messagerie.idMessage}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Détail</button></a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
