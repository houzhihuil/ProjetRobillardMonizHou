<%@ page import="cgodin.models.entities.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<h1 style="text-align: center; margin-top: 50px"><%= "SOS Animal" %>
</h1>
<br/>
<head>
    <title>SOS Animal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <script src=
                    "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <style>
        .center {
            margin: auto;
            width: 60%;
        }
    </style>
</head>
<body>

<% String message = (String) request.getParameter("upload"); %>
<% if (message != null) { %>
<div class="alert alert-success"><%= message %>
</div>

<% }
%>

<form action="annonce" method="post" class="center">
    <!-- Type of announcement -->
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="typeAnnonce" id="perdu" value="perdu" checked>
        <label class="form-check-label" for="perdu">
            Animal perdu
        </label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="typeAnnonce" id="retrouve" value="retrouve">
        <label class="form-check-label" for="retrouve">
            Animal retrouvé
        </label>
    </div>
    <!-- Location and species -->
    <div class="mb-3">
        <label for="localisation" class="form-label">Ville</label>
        <input type="text" class="form-control" id="localisation" name="localisation">
    </div>
    <div class="mb-3">
        <label for="espece" class="form-label">Espèce de l'animal</label>
        <select class="form-control" id="espece" name="espece">
            <% List<Espece> especes = (List<Espece>) request.getAttribute("especes");
                for (Espece espece : especes) { %>
            <option value="<%= espece.getEspece() %>"><%= espece.getEspece() %>
            </option>
            <% } %>
        </select>
    </div>
    <!-- Gender -->
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="sexe" id="male" value="male" checked>
        <label class="form-check-label" for="male">
            Male
        </label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="sexe" id="femelle" value="femelle">
        <label class="form-check-label" for="femelle">
            Femelle
        </label>
    </div>
    <!-- Description and notes -->
    <div class="form-group">
        <label for="notes">Description et notes sur l'animal</label>
        <textarea class="form-control" id="notes" name="notes" rows="3"></textarea>
    </div>
    <br>
    <!-- Add photo button and hidden inputs -->
    <div>
        <img id="idPhoto" src="${photos.get(0).photoURL}" alt="Uploaded Image" width="300"/>
        <br>
        <input hidden="hidden" form-check-input type="text" name="idPhoto" value="${photos.get(0).idPhoto}"/><br>
        <input hidden="hidden" form-check-input type="text" name="photoIDPhoto" value="${photos.get(0).idPhoto}"/><br>
    </div>

    <button type="submit" class="btn btn-primary" value="ajouter">Créer l'annonce</button>
</form>
</body>
</html>
