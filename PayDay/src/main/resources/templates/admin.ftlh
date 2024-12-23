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
    <h4 class="panel_title">Панель администратора</h4>
    <table border="1">
        <tr>
            <th class="smooth">ID</th>
            <th class="smooth">Email</th>
            <th class="smooth">Номер телефона</th>
            <th class="smooth">Баланс</th>
            <th class="smooth">Активность</th>
            <th class="smooth">Роли</th>
            <th class="smooth">Бан</th>
            <th class="smooth">Редактирование</th>
            <th class="smooth">Подробная информация</th>
        </tr>
        <#list users as user>
            <tr>
                <th>${user.id}</th>
                <th>${user.email}</th>
                <th class="color_phone">${user.phoneNumber}</th>
                <th>${user.accountBalance}</th>
                <th><#if user.active>true<#else>false</#if></th>
                <th><#list user.roles as role>${role}</#list></th>
                <th>
                    <form action="/admin/user/ban/${user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input class="Ban" type="submit" value="Бан">
                    </form>
                </th>
                <th><a class="moreinfo" href="/admin/user/edit/${user.id}">Редактирование</a></th>
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