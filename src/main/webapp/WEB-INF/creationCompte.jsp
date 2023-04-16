
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    input {
      background-color: chocolate;
    }
  </style>
</head>
<body>
<h1 style="text-align: center; margin-top: 50px"><%= "SOS Animal" %>
</h1>
<br/>
<form action="compte" method="post" class="center" style="background-color: #9DC4BC; padding: 20px; border: solid 2px white">
  <div class="mb-3">
    <label for="nom" class="form-label">nom</label>
    <input type="text" class="form-control" id="nom" name="nom">

  </div>
  <div class="mb-3">
    <label for="prenom" class="form-label">prenom</label>
    <input type="text" class="form-control" id="prenom" name="prenom">
  </div>

  <div class="mb-3">
    <label for="courriel" class="form-label">courriel</label>
    <input type="text" class="form-control" id="courriel" name="courriel">
  </div>


  <div class="mb-3">
    <label for="lieuResidence" class="form-label">Lieu de residence</label>
    <input type="text" class="form-control" id="lieuResidence" name="lieuResidence">
  </div>

  <div class="mb-3">
    <label for="motDePasse" class="form-label">mot de passe</label>
    <input type="password" class="form-control" id="motDePasse" name="motDePasse">
  </div>

  <div class="mb-3">
    <label for="noTelephone" class="form-label">telephone</label>
    <input type="text" class="form-control" id="noTelephone" name="noTelephone">
  </div>
  <br>
  <button type="submit" class="btn btn" value="ajouter" style="margin: auto; background-color: #F3d4b0 ">Creer un compte</button>

</form>
</body>
</html>
