<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SOS Animal</title>
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
<%--<img src="<%=request.getContextPath()%>logo.png" alt="Logo SOS Animal">--%>
<%--<img src="<c:url value="/resources/images/logoSOS.png" />" alt="image"/>--%>
<%--<img src="<c:url value="/resources/images/logo.png" />" alt="image" />--%>
<%--<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Description de l'image">--%>

<h1 style="text-align: center; margin-top: 50px"><%= "SOS Animal" %>

</h1>
<br/>
<form class="center" action="utilisateur/login" method="post"  style="background-color: #9DC4BC; padding: 20px; border: solid 2px white">
    <div class="mb-2">
        <label for="exampleInputEmail1" class="form-label">Adresse Courriel</label>
        <input class="form-control" id="exampleInputEmail1" style="background-color: white"  name="courriel">
        <div id="emailHelp" class="form-text"></div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="motDePasse">
    </div>
    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">se rappeler de moi</label>
    </div>
    <br>
    <button type="submit" class="btn btn" style="margin: auto; background-color: #F3d4b0 ">Se connecter</button>
    <br>
    <br>
    <button type="button" class="btn btn" style="margin: auto; background-color: #F3d4b0 "><a href="creation/compte" style="text-decoration:none; color: black">Créer
        un compte</a></button>
    <c:if test="${not empty erreur}">
        <div class="text-danger">${erreur}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="text-danger">${error}</div>
    </c:if>
</form>
</body>
</html>