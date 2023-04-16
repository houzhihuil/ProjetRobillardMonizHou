<%@ page import="cgodin.models.entities.*" %>
<%@ page import="cgodin.models.DAO.UtilisateurDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Envoyer un message</title>
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

        input {
            background-color: chocolate;
        }
    </style>
</head>
<body>

<%
    String destinataireIDMembre = request.getParameter("id");
    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    Utilisateur utilisateur = utilisateurDAO.getUtilisateurById(Integer.parseInt(destinataireIDMembre));
%>
<h1 style="text-align: center; margin-top: 50px">Contacter <%=utilisateur.getPrenom()%>
</h1>
<form action="addmessagerie" method="post" class="center">
    <div class="mb-3" hidden>    <%-- test pour voir le destinataire // enlever le "hidden" pour voir --%>
        <label for="destination" class="form-label">Destinataire :</label>
        <select class="form-control" id="destination" name="destinataireIDMembre">
            <option value="<%=destinataireIDMembre%>"><%=utilisateur.getPrenom()%> <%=utilisateur.getNom()%>
            </option>
        </select>
    </div>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <textarea class="form-control mt-5" rows="5" placeholder="Votre message" id="message"
                      name="message"></textarea>
            <%-- Affichage du message ici --%>
            <c:if test="${not empty message}">
                <div class="alert alert-success mt-3">${message}</div>
            </c:if>
            <button type="submit" class="btn btn-primary mt-3">Envoyer</button>
        </div>
        <div class="col-lg-2"></div>
    </div>
</form>
</body>
</html>