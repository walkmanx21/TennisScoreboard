<!DOCTYPE html>
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
            <form action="ссылка">
                <label class="search_label">Поиск по игроку:
                    <input class="search_input" required placeholder="Введите имя игрока" type="text">
                    <button class="search_button">искать</button>
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
            <tr>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
            </tr>
            </tbody>
        </table>
        <div class="search-flexbox-container">
            <form action="${}" method="post" enctype="application/x-www-form-urlencoded">
                <button class="prev_btn" name="previous" value="${}">пред.</button>
                <button class="page_btn" name="page" value="${}">1</button>
                <button class="next_btn" name="next" value="${}">след.</button>
            </form>
        </div>
    </div>
</section>
</body>