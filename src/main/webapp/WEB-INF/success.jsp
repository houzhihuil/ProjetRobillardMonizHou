<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="message" value="${requestScope.message}" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File upload success</title>
</head>
<body>
<h1>File upload successful</h1>
<p>${message}</p>

<form method="get" action ="creationAnnonce/creerannonce2">
    <input type="hidden" id ="upload" value = "upload image Successfully" name="upload">
    <button type="submit">Retourner</button>
</form>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        document.querySelector("form").submit();
    });
</script>

</body>
</html>
