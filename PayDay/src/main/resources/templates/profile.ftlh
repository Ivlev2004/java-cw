<!DOCTYPE html>
<html>
<head>
    <title>PayDay</title>
    <link rel="stylesheet" href="static/cssFile.css">
</head>
<body>
<div class="container">
    <h1 class="bg_color">Payday</h1>
    <h4>Личный кабинет</h4>
    <hr class="no_hr">
    <br>
    <div>
        <h2 class="big_block">${user.name}</h2>
        <br>
        Баланс: <b>${user.accountBalance}</b>
        <br>
        Электронная почта: <b>${user.email}</b>
        <br>
        Номер телефона: <b>${user.phoneNumber}</b>
        <br>
        <br>

        <#if user.isAdmin()>
            <a class="big_block" href="/admin">
                Панель администратора
            </a><br>
            <#else>
                <a class="big_block" href="/my/transactions">
                    Мои пополнения
                </a>
        </#if>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn_registration" type="submit">
                Выйти из аккаунта
            </button>
        </form>
    </div>
</div>
</body>
</html>