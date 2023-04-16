<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="message" value="${requestScope.message}" />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Favorite set successfully</title>
</head>
<body>
<h1>${message}</h1>
<p>AnnonceIDAnnonce: ${AnnonceIDAnnonce}</p>
<p>UtilisateurIDMembree: ${UtilisateurIDMembree}</p>

<form method="get" action ="utilisateur/listeAnnonce">
  <input type="hidden"  value = "${AnnonceIDAnnonce}" name="id">
  <button type="submit">Retourner</button>
</form>

<%--<script>
  document.addEventListener("DOMContentLoaded", function() {
    document.querySelector("form").submit();
  });
</script>--%>

</body>
</html>
