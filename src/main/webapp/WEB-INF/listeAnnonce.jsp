<%@ page import="cgodin.models.entities.Annonce" %>
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
        ul {
            text-align: center;

        }

        li {
            display: inline-block;
            margin-right: 10px;
        }

    </style>
</head>
<body>
<h1 style="text-align: center; margin-top: 50px">Liste des Annonces</h1>
<br/>

<div class="center">
    <!-- Add filter form here -->
    <div class="container">
        <form action="${pageContext.request.contextPath}/utilisateur/listeAnnonce" method="get" class="form-inline">
            <label for="typeAnnonce" class="mr-2">Filtrer par:</label>
            <select id="typeAnnonce" name="typeAnnonce" class="form-control mr-2">
                <option value="">Tous</option>
                <option value="perdu">Perdu</option>
                <option value="trouvé">Trouvé</option>
            </select>
            <label for="espece" class="mr-2">Espèce:</label>
            <input type="text" id="espece" name="espece" placeholder="Rechercher une espèce" class="form-control mr-2">
            <label for="localisation" class="mr-2">Localisation:</label>
            <input type="text" id="localisation" name="localisation" placeholder="Rechercher une localisation"
                   class="form-control mr-2">
            <label for="startDate" class="mr-2">Date de début:</label>
            <input type="date" id="startDate" name="startDate" class="form-control mr-2">
            <label for="endDate" class="mr-2">Date de fin:</label>
            <input type="date" id="endDate" name="endDate" class="form-control mr-2">
            <br>
            <button type="submit" class="btn btn-primary">Filtrer</button>
        </form>
    </div>

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
            <th scope="col">Actif</th>
            <th scope="col">Espèce Nom</th>
            <th scope="col">Utilisateur ID Membre</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
<%--        <c:forEach var="annonce" items="${annonces}">--%>
<%--            <tr>--%>
<%--                <td>${annonce.idAnnonce}</td>--%>
<%--                <td>${annonce.typeAnnonce}</td>--%>
<%--                <td>${annonce.date}</td>--%>
<%--                <td>${annonce.localisation}</td>--%>
<%--                <td>${annonce.espece}</td>--%>
<%--                <td>${annonce.sexe}</td>--%>
<%--                <td>${annonce.notes}</td>--%>
<%--                <td>${annonce.annonceEstActive ? "Oui" : "Non"}</td>--%>
<%--                <td>${annonce.especeNom}</td>--%>
<%--                <td>${annonce.utilisateurIDMembre}</td>--%>

<%--                &lt;%&ndash;<td><a href="/?id=${annonce.idAnnonce}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Détail</button></a></td>&ndash;%&gt;--%>
<%--                <td><a href="../addmessagerie?id=${annonce.utilisateurIDMembre}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Envoyer message</button></a></td>--%>

<%--                <td><a href="../addannoncesignalee?id1=${annonce.idAnnonce}&id2=${annonce.utilisateurIDMembre}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Signaler annonce</button></a></td>--%>

<%--                <td><a href="../creationAnnonce/desactivaterAnnonce?id=${annonce.idAnnonce}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Desactiver annonce</button></a></td>--%>



<%--            </tr>--%>
<%--        </c:forEach>--%>

<c:forEach var="annonce" items="${annonces}" varStatus="loop">
   <%-- <c:if test="${annonce.annonceEstActive}">--%>
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
            <td>${annonce.annonceEstActive ? "Oui" : "Non"}</td>
            <td>${annonce.especeNom}</td>
            <td>${annonce.utilisateurIDMembre}</td>
<%--            <td><a href="../addmessagerie?id=${annonce.utilisateurIDMembre}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Envoyer message</button></a></td>--%>
<%--            <td><a href="../addannoncesignalee?id1=${annonce.idAnnonce}&id2=${annonce.utilisateurIDMembre}"><button style="margin: auto; background-color: #...">Signaler</button></a></td>--%>
                                <td><a href="../addmessagerie?id=${annonce.utilisateurIDMembre}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Envoyer message</button></a></td>

                                <td><a href="../addannoncesignalee?id1=${annonce.idAnnonce}&id2=${annonce.utilisateurIDMembre}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Signaler annonce</button></a></td>

                                <td><a href="../creationAnnonce/desactivaterAnnonce?id=${annonce.idAnnonce}"><button style="margin: auto; background-color: #F3d4b0 " class="btn btn">Desactiver annonce</button></a></td>
                                <td>
                                    <a href="../addfavorie?id=${annonce.idAnnonce}">
                                        <c:choose>
                                            <c:when test="${annonces[loop.index].favorite}">
                                                ${annonces[loop.index].idAnnonce } <img src="<c:url value='/images/favoriteActive.png'/>" alt="favori" width ="50" />
                                            </c:when>
                                            <c:otherwise>
                                                <img src="<c:url value='/images/favorite.png' />" alt="favori" width ="50" />
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </td>

        </tr>
    <%--</c:if>--%>
</c:forEach>


        </tbody>
    </table>

</div>

<ul>
    <li><a href="?page=1">
        1
    </a></li>
<c:if test="${currentPage > 1}">
    <li><a href="?page=${currentPage - 1}">
        Previous
    </a></li>
</c:if>
<li><strong>${currentPage}</strong></li>
<c:if test="${currentPage < totalPages}">
    <li><a href="?page=${currentPage + 1}   ">
        Next
    </a></li>
</c:if>
    <li><a href="?page=${totalPages}   ">
        ${totalPages}
    </a></li>
</ul>

</body>
</html>
