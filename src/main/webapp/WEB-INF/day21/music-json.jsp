<%--
  Created by IntelliJ IDEA.
  User: Julien
  Date: 12/11/2023
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Music Artist</title>
</head>
<body>
<h2 style="margin-left: 6rem; margin-top: 1rem;"><a href="index.jsp">Home</a></h2>
<div class="container my-4">
    <div class="row">
        <c:forEach items="${music}" var="music">
            <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6">
                <div class="card mb-4">
                    <img class="card-img-top rounded" src="${music.picture}" alt="${music.name}">
                    <div class="card-body">
                        <h5 class="card-title">${music.name}</h5>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
