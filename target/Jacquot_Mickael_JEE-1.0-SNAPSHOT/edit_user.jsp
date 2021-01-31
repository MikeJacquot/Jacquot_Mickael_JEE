<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="parts/links.jsp"%>
    <title>Edit user</title>
</head>
<body>
<%@include file="parts/navbar.jsp"%>
<h1>Editer Utilisateur</h1>

<div class="container formcss">

<form method="post" enctype="multipart/form-data">

    <div class="form-group">
        <label for="nom">Nom</label>
        <input type="text" class="form-control"
               id="nom"
               name="nom"
               placeholder="nom" value="${chosenOne.lastName}">
    </div>
    <div class="form-group">
        <label for="prenom">Prenom</label>
        <input type="text" class="form-control"
               id="prenom"
               name="prenom"
               placeholder="prenom" value="${chosenOne.firstName}">
    </div>
    <div class="form-group">
        <label for="date">Date d'entrée</label>
        <input type="date" class="form-control"
               id="date"
               name="date"
               placeholder="Choisissez la date d'entrée" value="${chosenOne.date_entree}">
    </div>
    <div class="form-group">
        <label for="tel">Numero de telephone</label>
        <input type="text" class="form-control"
               id="tel"
               name="tel"
               placeholder="Numero de téléphone" value="${chosenOne.numero_tel}">
    </div>
    <div class="form-group">
        <label for="login">Login</label>
        <input type="text" class="form-control"
               id="login"
               name="login"
               placeholder="login" value="${chosenOne.login}">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="text" class="form-control"
               id="password"
               name="password"
               placeholder="password" value="${chosenOne.password}">
    </div>
    <div class="form-group">
        <label for="image">Image à upload</label>
        <input type="file" accept="image/jpeg"
               class="form-control"
               id="image"
               name="image">
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="role" id="admin" value="admin" <c:if  test="${chosenOne.role.equals('admin')}">checked</c:if>>
        <label class="form-check-label" for="admin">
            Role Admin
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="role" id="user" value="user" <c:if  test="${chosenOne.role.equals('user')}">checked</c:if>>
        <label class="form-check-label" for="user">
            Role Utilisateur
        </label>
    </div>
    <input type='submit' value='valider'/>
</form>

</div>


</body>
</html>

