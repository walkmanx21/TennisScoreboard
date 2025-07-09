<%@ page import="java.nio.file.Path" %>
<%@ page import="java.io.File" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Табло теннисного матча</title>
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
        <h2>Имена игроков одинаковы!</h2>
        <form action="${pageContext.request.contextPath}/new-match">
            <div class="samename_users_block">
                <button class="samename_users_btn">Введите уникальные имена</button>
            </div>
        </form>
    </div>
</section>
</body>

</html>