<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="parts/links.jsp"%>
    <title>Welcome user</title>
</head>
<body>
<%@include file="parts/navbar.jsp"%>
<h1>Bienvenue !</h1>

<div class="container card-group">
    <c:forEach items="${users}" var="user" >
        <div class="card" style="width: 18rem;">

            <img class="card-img-top" src="${user.image_link}" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">${user.lastName} - ${user.firstName}</h5>
                <p class="card-text">Date d'entrée : ${user.date_entree}</p>
                <p class="card-text">numero de telephone : ${user.numero_tel}</p>
                <p class="card-text">Role : ${user.role}</p>
            </div>
        </div>

    </c:forEach>
</div>
</body>
</html>
