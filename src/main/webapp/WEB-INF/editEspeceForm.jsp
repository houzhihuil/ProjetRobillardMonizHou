<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PHILIP
  Date: 2023-03-23
  Time: 4:50 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="post" action ="editEspece" class="center">

            <div class="mb-3">
                <label name="espece" class="form-label">Espece : ${espece.espece}</label>
                <input class="form-control" type="hidden" name="espece" id="espece" value =${espece.espece}>
            </div>

            <div class="mb-3">
                <label name="photoURL" class="form-label">PhotoURL</label>
                <input class="form-control" type="text" name="photoUrl" id="photoURL" value =${espece.photoUrl}>
            </div>

            <label for="description" class="form-label">Description</label><br>
            <textarea rows = "5" cols = "120" id="description" name = "description"> ${espece.description}
            </textarea><br><br>

            <button type="submit" class="btn btn-primary">Modifier</button>
</form>

</body>
</html>
