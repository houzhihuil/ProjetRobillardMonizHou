<%@ page import="cgodin.models.entities.Annonce" %>
<%@ page import="java.util.List" %>
<%@ page import="cgodin.models.entities.Espece" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PHILIP
  Date: 2023-04-3
  Time: 4:50 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SOS Animal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        .center {
            margin: auto;
            width: 60%;
        }
    </style>
</head>
<body>
<h1 style="text-align: center; margin-top: 50px"><%= "SOS Animal" %>
</h1>
<form method="post" action ="modifierMesAnnonce" class="center">

            <div class="mb-3">
                <label name="annonce" class="form-label">Annonce : ${monannonce.idAnnonce}</label>
                <input class="form-control" type="hidden" name="idAnnonce" id="annonce" value =${monannonce.idAnnonce}>
            </div>
            <!-- Type of announcement -->
            <label name="typeAnnonce" class="form-label">TypeAnnonce :</label>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="typeAnnonce" id="perdu" value="perdu" checked>
                <label class="form-check-label" for="perdu">
                    Animal perdu
                </label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="typeAnnonce" id="retrouve" value="retrouvé">
                <label class="form-check-label" for="retrouve">
                    Animal retrouvé
                </label>
            </div>
            <script>
                if ("${monannonce.typeAnnonce}" !== "perdu") {
                    $("#perdu").prop("checked", false);
                    $("#retrouve").prop("checked", true);
                }
            </script>
            <!-- Location and species -->
            <div class="mb-3">
                <label name="localisation" class="form-label">Localisation</label>
                <input class="form-control" type="text" name="localisation" id="localisation" value =${monannonce.localisation}>
            </div>
            <%--            <div class="mb-3">
                            <label for="espece" class="form-label">Espèce de l'animal</label>
                            <select class="form-control" id="espece" name="espece">
                                <% List<Espece> especes = (List<Espece>) request.getAttribute("especes");
                                    for (Espece espece : especes) { %>
                                <option value="<%= espece.getEspece() %>"><%= espece.getEspece() %>
                                </option>
                                <% } %>
                            </select>
                        </div>--%>

                <div class="mb-3">
                    <label for="espece" class="form-label">Espèce de l'animal</label>
                    <select class="form-control" id="espece" name="espece">
                        <c:forEach var="espece" items="${especes}">
                            <option value="${espece.espece}" ${monannonce.espece == espece.espece ? 'selected' : ''}>${espece.espece}</option>
                        </c:forEach>
                    </select>
                </div>
            <!-- Gender -->
            <label name="sexe" class="form-label">Sexe :</label><br/>
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
            </div><br/>
            <script>
                if( "${monannonce.sexe}" !== "male")   {
                    // document.getElementById("femelle").checked = true;
                    $("#femelle").prop("checked", true);
                    $("#male").prop("checked", false);
                }
            </script>


            <label for="notes" class="form-label">Notes</label><br>
            <textarea rows = "5" cols = "120" id="notes" name = "notes"> ${monannonce.notes}
            </textarea><br><br>


    <br/>

            <button type="submit" class="btn btn-primary">Modifier</button>
</form>

</body>
</html>
