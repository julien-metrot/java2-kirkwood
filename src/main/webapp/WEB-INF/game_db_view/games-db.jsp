<%--
  Created by IntelliJ IDEA.
  User: Julien
  Date: 11/26/2023
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Games Database</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

    <div class="container">
        <h1>Games Savings</h1>
        <c:if test="${games.size() > 0}">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Game ID</th>
                        <th scope="col">Game Name</th>
                        <th scope="col">Release Price</th>
                        <th scope="col">Person ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Purchase Price</th>
                        <th scope="col">Savings</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${games}" var="game">
                        <tr>
                            <th scope="row">${game.game_ID}</th>
                            <td>${game.game_name}</td>
                            <td>${game.release_price}</td>
                            <td>${game.person_ID}</td>
                            <td>${game.first_name}</td>
                            <td>${game.last_name}</td>
                            <td>${game.purchase_price}</td>
                            <td>${game.savings}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
