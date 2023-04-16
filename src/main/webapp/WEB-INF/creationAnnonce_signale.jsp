<%@ page import="cgodin.models.entities.Utilisateur" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: PHILIP
  Date: 2023-03-14
  Time: 2:07 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Ajout d'une annonce signalée</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <style>
        .center{
            margin:auto;
            width:60%;
        }
        input{
            background-color: chocolate;
        }
    </style>
</head>
<body>
<%
    String idParam1 = request.getParameter("id1");
    int idAnnonce = 0; // default value if parameter is null
    if (idParam1 != null) {
        idAnnonce = Integer.parseInt(idParam1);
    }
    String idParam2 = request.getParameter("id2");
    int utilisateurIDMembre = 0; // default value if parameter is null
    if (idParam2 != null) {
        utilisateurIDMembre = Integer.parseInt(idParam2);
    }

%>
<h1 style="text-align: center; margin-top: 50px">Formulaire d'ajout d'une annonce signalée</h1>

<form action="addannoncesignalee" method="post" class="center">

    <div class="mb-3">
        <%--<label name="annonceIDAnnonce" class="form-label">Choisi annonce : Annonce ID - Annonce Type</label>--%>
        <%--<select class="form-control" id="destination" name="annonceIDAnnonce">
            <!-- Loop through the annonce list and display their information -->
            <c:forEach var="annonce" items="${annonceList}">
                <option value="${annonce.idAnnonce}"> ${annonce.idAnnonce} </option>
            </c:forEach>
        </select>--%>
        <input type="hidden" id="annonceIDAnnonce" name="annonceIDAnnonce" value= <%=idAnnonce%>>

    </div>
    </div>

    <div class="mb-3">
        <%--<label name="utilisateurIDMembre" class="form-label">utilisateur :  ID - Nom - Prenom</label>--%>
        <%--<select class="form-control" id="utilisateurIDMembre" name="utilisateurIDMembre">
            <!-- Loop through the utilisateurs list and display their information -->
            <c:forEach var="utilisateur" items="${utilisateurs}">
                <option value="${utilisateur.idMembre}">${utilisateur.idMembre} ${utilisateur.nom} ${utilisateur.prenom}</option>
            </c:forEach>
        </select>--%>
        <input type="hidden" id="utilisateurIDMembre" name="utilisateurIDMembre" value= <%=utilisateurIDMembre%>>

    </div>

    <div class="mb-3">
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="type" id="as1" value="language offensant" checked>
            <label class="form-check-label" for="as1">
                language offensant
            </label>
            </label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="type" id="as2" value="fraude">
            <label class="form-check-label" for="as2">
                fraude
            </label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="type" id="as3" value="mauvaise information">
            <label class="form-check-label" for="as3">
                mauvaise information
            </label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="type" id="as4" value="autre">
            <label class="form-check-label" for="as4">
                autre
            </label>
        </div>
    </div>

    <div class="form-group">
        <label for="notes" >notes</label>
        <textarea class="form-control" id="notes" name="notes" rows="3"></textarea>
    </div>
    <br>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>

</body>
</html>


