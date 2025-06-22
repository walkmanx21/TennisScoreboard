<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Табло теннисного матча</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fonts.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
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