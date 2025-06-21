<%@ page import="java.nio.file.Path" %>
<%@ page import="java.io.File" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>

<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Табло теннисного матча</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<section class="new-match">
    <div class="container">
        <h1 class="title">Новый матч</h1>
        <h2 class="entering-name">Введите имена игроков:</h2>
        <form class="name-form" action="#">
            <input name="player1-name" required placeholder="Первый игрок" type="text">
            <input name="player2-name" required placeholder="Второй игрок" type="text">
            <button class="new_match_btn">Начать</button>
        </form>

    </div>

</section>
</body>

</html>