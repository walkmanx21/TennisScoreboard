<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.UUID" %>
<%@ page import="org.walkmanx21.model.Match" %>
<%@ page import="java.util.concurrent.ConcurrentHashMap" %>
<%@ page import="org.walkmanx21.dao.MatchDao" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>


<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Текущий матч</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<section class="completed-matches">
    <div class="container">
        <h1 class="title">Завершенные матчи</h1>
        <div class="search_flexbox">
            <form action="${pageContext.request.contextPath}/matches" method="get">
                <label class="search_label">Поиск по игроку:
                    <input class="search_input" name="filter_by_player_name" required placeholder="Введите имя игрока" type="text">
                    <button class="search_button" >искать</button>
                </label>
            </form>
        </div>
        <table>
            <thead>
            <tr>
                <th>№ матча</th>
                <th>Игрок №1</th>
                <th>Игрок №2</th>
                <th>Победитель</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="match" items="${matches}">
                <tr>
                    <td><c:out value="${match.id}"/></td>
                    <td><c:out value="${match.firstPlayer.name}"/></td>
                    <td><c:out value="${match.secondPlayer.name}"/></td>
                    <td><c:out value="${match.winner.name}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="search-flexbox-container">
            <form action="${pageContext.request.contextPath}/matches" method="get" enctype="application/x-www-form-urlencoded">
                <button class="prev_btn" name="page" value="${prev}">пред.</button>
                <button class="page_btn" name="page" value="${page}">${page}</button>
                <button class="next_btn" name="page" value="${next}">след.</button>
            </form>
        </div>
    </div>
</section>
</body>