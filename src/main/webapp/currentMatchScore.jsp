<%@ page import="java.nio.file.Path" %>
<%@ page import="java.io.File" %>
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
<section class="current-match">
    <div class="container">
        <h1 class="title">Текущий матч</h1>
        <h2 class="score">Счет</h2>
        <table border="1px">
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
                <td>Игрок №1</td>
                <td>№1</td>
                <td>№1</td>
                <td>№1</td>
            </tr>
            <tr>
                <td>Игрок №2</td>
                <td>№2</td>
                <td>№2</td>
                <td>№2</td>
            </tr>
            </tbody>
        </table>
        <div class="flexbox-container">
            <form action="ссылка" method="post">
                <button class="player_win_btn">Игрок №1 выиграл очко</button>
                <button class="player_win_btn">Игрок №2 выиграл очко</button>
            </form>
        </div>
    </div>
</section>
</body>