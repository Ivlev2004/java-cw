<!DOCTYPE html>
<html>
<head>
    <title>PayDay</title>
    <link rel="stylesheet" href="static/cssFile.css">
</head>
<body>
<div class="container">
    <h1 class="bg_color">Payday</h1>
    <h2>Профиль пользователя ${user.name}</h2>
    <hr class="no_hr">
    <br>
    <div>
        <br>
        ID: <b>${user.id}</b>
        <br>
        Электронная почта: <b>${user.email}</b>
        <br>
        Номер телефона: <b>${user.phoneNumber}</b>
        <br>
        Баланс: <b>${user.accountBalance}</b>
        <br>
        <br>
        <a class="big_block" href="/my/transactions/${user.id}">
            Пополнения пользователя
        </a>
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