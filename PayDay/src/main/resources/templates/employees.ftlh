<!DOCTYPE html>
<html>
<head>
    <title>PayDay</title>
    <link rel="stylesheet" href="static/cssFile.css">
</head>
<body>
<div class="container">

    <h1 class="bg_color">Payday</h1>
    <hr class="no_hr">
    <h4 class="panel_title">Сотрудники</h4>
    <table border="1">
        <tr>
            <th class="smooth">ID</th>
            <th class="smooth">Email</th>
            <th class="smooth">Номер телефона</th>
            <th class="smooth">Подробная информация</th>
            <th class="smooth">Баланс</th>
        </tr>
        <#list users as user>
            <tr>
                <th>${user.id}</th>
                <th>${user.email}</th>
                <th class="color_phone">${user.phoneNumber}</th>
                <th class="color_phone">${user.accountBalance}</th>
                <th><a class="moreinfo" href="/user/${user.id}">Подробная информация</a></th>
            </tr>
        <#else>
            <hr>
            <h3>Пользователей нет</h3>
        </#list>
    </table>
</div>
</body>
</html>