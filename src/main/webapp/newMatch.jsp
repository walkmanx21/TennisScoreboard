<%@ page import="java.nio.file.Path" %>
<%@ page import="java.io.File" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>

<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Новый матч</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<header>
    <div class="header_flexbox_container">
        <form action="${pageContext.request.contextPath}/">
            <button class="header_btn" id="main">Главная страница</button>
        </form>
        <div class="line"></div>
        <form action="${pageContext.request.contextPath}/new-match">
            <button class="header_btn" id="new">Новый матч</button>
        </form>
        <div class="line"></div>
        <form action="${pageContext.request.contextPath}/matches">
            <button class="header_btn" id="completed">Завершенные матчи</button>
        </form>
    </div>
</header>
<section class="new-match">
    <div class="container">
        <h1 class="title">Новый матч</h1>
        <h2 class="entering-name">Введите имена игроков:</h2>
        <form class="name-form" action="${pageContext.request.contextPath}/new-match" method="post">
            <input name="firstPlayerName" required placeholder="Первый игрок" type="text">
            <input name="secondPlayerName" required placeholder="Второй игрок" type="text">
            <button class="new_match_btn">Начать</button>
        </form>
    </div>

</section>
</body>

</html>