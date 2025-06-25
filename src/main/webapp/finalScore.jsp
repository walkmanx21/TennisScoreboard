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
    <title>Табло теннисного матча</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<section class="final-score">
    <div class="container">
        <h1 class="title">Матч завершен</h1>
        <h2 class="score">Финальный счет</h2>
        <table>
            <thead>
            <tr>
                <th>Игрок</th>
                <th>Сеты</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${firstPlayerName}</td>
                <td>${firstPlayerSets}</td>
            </tr>
            <tr>
                <td>${secondPlayerName}</td>
                <td>${secondPlayerSets}</td>
            </tr>
            </tbody>
        </table>
        <div class="flexbox-container">
            <form action="">
                <button class="home_btn">На главную страницу</button>
            </form>
        </div>
    </div>
</section>
</body>

</html>