<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Game Directory</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="game-json">Game Directory</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Sort
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="game-json?sort=az&q=${q}">A-Z</a></li>
                        <li><a class="dropdown-item" href="game-json?sort=za&q=${q}">Z-A</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Filter by Genre
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown3">
                        <li><a class="dropdown-item" href="game-json?sort=${s}&q=${q}&genre=">All</a></li>
                        <c:forEach items="${genres}" var="genre">
                            <li><a class="dropdown-item" href="game-json?sort=${s}&q=${q}&genre=${genre}">${genre}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" action="game-json" method="GET">
                <input class="form-control me-2" name="q" value="${q}" type="search" placeholder="Search" aria-label="Search">
                <input name="sort" value="${s}" type="hidden">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<h2 style="margin-left: 6rem; margin-top: 1rem;"><a href="index.jsp">Home</a></h2>
<div class="container my-4">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Genre</th>
                <th scope="col">Release Date</th>
                <th scope="col">Platform</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${games}" var="game" varStatus="count">
                <tr>
                    <th scope="row">${count.count}</th>
                    <td>${game.title}</td>
                    <td>${game.description}</td>
                    <td>${game.genre}</td>
                    <td>${game.release_date}</td>
                    <td>${game.platform}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
