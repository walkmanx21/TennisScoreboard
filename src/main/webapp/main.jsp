<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Табло теннисного матча</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fonts.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
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
<section class="main">
    <div class="container">
        <h1 class="title">Табло теннисного матча</h1>
    </div>
    <form action="${pageContext.request.contextPath}/new-match" method="GET">
        <button class="new_match_btn">Начать новый матч</button>
    </form>
    <form action="${pageContext.request.contextPath}/matches" method="GET">
        <button class="completed_matches_btn">Завершенные матчи</button>
    </form>
</section>
</body>

</html>