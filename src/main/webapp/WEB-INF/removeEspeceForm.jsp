<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<% String nomEspece = request.getParameter("nom"); %>

<form method="post" action ="removeEspece">
  <%--<label name="nomEspece" >nomEspece: </label>--%>
  <input type="hidden" id ="nomEspece" value = <%=nomEspece %> name="nomEspece">
  <button type="submit">Supprimer</button>
</form>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        document.querySelector("form").submit();
    });
</script>

</body>
</html>
