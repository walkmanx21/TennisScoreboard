<%@ page import="java.nio.file.Path" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.UUID" %>
<%@ page import="org.walkmanx21.model.Match" %>
<%@ page import="java.util.concurrent.ConcurrentHashMap" %>
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
<header>
    <div class="header_flexbox_container">
        <form action="${pageContext.request.contextPath}/">
            <button class="header_btn" id="main">Главная страница</button>
        </form>
        <div class="vertical_line"></div>
        <form action="${pageContext.request.contextPath}/new-match">
            <button class="header_btn" id="new">Новый матч</button>
        </form>
        <div class="vertical_line"></div>
        <form action="${pageContext.request.contextPath}/matches">
            <button class="header_btn" id="completed">Завершенные матчи</button>
        </form>
    </div>
</header>
<section class="current-match">
    <div class="container">
        <h1 class="title">Текущий матч</h1>
        <h2 class="score">Счет</h2>
        <table>
            <thead>
            <tr>
                <th>Игрок</th>
                <th>Сеты</th>
                <th>Геймы</th>
                <th>Очки</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${firstPlayerName}</td>
                <td>${firstPlayerSets}</td>
                <td>${firstPlayerGames}</td>
                <td>${firstPlayerPoints}</td>
            </tr>
            <tr>
                <td>${secondPlayerName}</td>
                <td>${secondPlayerSets}</td>
                <td>${secondPlayerGames}</td>
                <td>${secondPlayerPoints}</td>
            </tr>
            </tbody>
        </table>
        <div class="flexbox-container">
            <form action="${url}" method="post" enctype="application/x-www-form-urlencoded">
                <button class="player_win_btn" name="PlayerWin" value="${firstPlayerId}">${firstPlayerName} выиграл очко</button>
                <button class="player_win_btn" name="PlayerWin" value="${secondPlayerId}">${secondPlayerName} выиграл очко</button>
            </form>
        </div>
    </div>
</section>
</body>