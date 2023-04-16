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
<h1 style="text-align: center; margin-top: 50px">Formulaire d'ajout d'une espece</h1>

<form action="addespece" method="post" class="center">

    <div class="mb-3">
        <label name="espece" class="form-label">Espece</label>
        <input class="form-control" type="text" name="espece" id="espece">
    </div>

    <div class="mb-3">
        <label name="photoURL" class="form-label">PhotoURL</label>
        <input class="form-control" type="file" name="photoUrl" id="photoURL">
    </div>

    <div class="form-group">
        <label for="description">Description</label>
        <textarea class="form-control" id="description" name="description" rows="3"></textarea>
        </textarea>
    </div>
    <br>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>

</body>
</html>


