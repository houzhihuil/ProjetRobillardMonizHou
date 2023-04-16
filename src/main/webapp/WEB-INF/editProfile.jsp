<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<h1 style="text-align: center; margin-top: 50px"><%= "SOS Animal" %>
</h1>
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
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
<div class="container">
    <form action="${pageContext.request.contextPath}/utilisateur/updateProfile" class="center" method="post"
          onsubmit="return validateForm();" style="background-color: #9DC4BC; padding: 20px; border: solid 2px white">
        <input type="hidden" name="idMembre" value="${utilisateur.idMembre}"/>

        <div class="mb-3">
            <label for="nom">Nom:</label>
            <input type="text" class="form-control" id="nom" name="nom" value="${utilisateur.nom}" required>
        </div>

        <div class="mb-3">
            <label for="prenom">Prénom:</label>
            <input type="text" class="form-control" id="prenom" name="prenom" value="${utilisateur.prenom}" required>
        </div>

        <div class="mb-3">
            <label for="courriel">Courriel:</label>
            <input type="email" class="form-control" id="courriel" name="courriel" value="${utilisateur.courriel}"
                   required>
        </div>

        <div class="mb-3">
            <label for="lieuResidence">Lieu de résidence:</label>
            <input type="text" class="form-control" id="lieuResidence" name="lieuResidence"
                   value="${utilisateur.lieuResidence}" required>
        </div>

        <div class="mb-3">
            <label for="noTelephone">Numéro de téléphone:</label>
            <input type="text" class="form-control" id="noTelephone" name="noTelephone"
                   value="${utilisateur.noTelephone}" required>
        </div>

        <div class="mb-3">
            <label for="motDePasse">Mot de passe:</label>
            <input type="password" class="form-control" id="motDePasse" name="motDePasse"
                   value="${utilisateur.motDePasse}" required>
        </div>
        <br>
        <input type="submit" value="Modifier votre compte" class="btn btn" style="margin: auto; background-color: #F3d4b0 "/>
    </form>

    <form action="${pageContext.request.contextPath}/utilisateur/deleteProfile" class="center" method="post"
          onsubmit="return confirmDelete();">
        <input type="hidden" name="idMembre" value="${utilisateur.idMembre}"/>

        <input type="submit" value="Supprimer votre compte" class="btn btn" style="margin: auto; background-color: #F3d4b0; margin: 20px "/>
    </form>
</div>
<script>
    function validateForm() {
        alert("Votre compte à été mis à jour!");
        return true;
    }

    function confirmDelete() {
        return confirm("Êtes-vous sûr de vouloir supprimer votre compte? Cette action est irréversible.");
    }
</script>
</body>
</html>