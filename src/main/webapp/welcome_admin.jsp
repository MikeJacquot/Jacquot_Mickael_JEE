<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="parts/links.jsp"%>
    <title>mon admin !</title>
</head>
<body>
<%@include file="parts/navbar.jsp"%>


<a  style="text-align: center ;display: block" href="${pageContext.servletContext.contextPath}/createuser">Créer un Utilisateur/Admin</a>
<div class="container card-group">

<c:forEach items="${users}" var="user" >
    <div class="card" style="width: 18rem;">

    <img class="card-img-top" src="${user.image_link}" alt="Card image cap">
    <div class="card-body">
        <h5 class="card-title">${user.lastName} - ${user.firstName}</h5>
        <p class="card-text">Date d'entrée : ${user.date_entree}</p>
        <p class="card-text">numero de telephone : ${user.numero_tel}</p>
        <p class="card-text">Role : ${user.role}</p>
        <p class="card-text">login : ${user.login}</p>
        <p class="card-text">password : ${user.password}</p>
        <a href="${pageContext.servletContext.contextPath}/edituser?id=${user.id}" class="btn btn-primary">Editer</a>
        <a href="${pageContext.servletContext.contextPath}/deleteuser?id=${user.id}" class="btn btn-danger">Supprimer</a>
    </div>
    </div>

</c:forEach>

</div>





</body>
</html>
