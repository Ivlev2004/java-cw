<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PayDay</title>
    <link rel="stylesheet" href="static/cssFile.css">
</head>
<body>
<div class="container">
    <h1 class="bg_color">Payday</h1>
    <hr class="big_block">
    <#if user.email??>
        <h2>Имя пользователя: <i>${user.name}</i></h2>
        <#if user.isAccountant()>
            <h3><i>Бухгалтер</i></h3>
        <#elseif user.isAdmin()>
            <h3><i>Администратор</i></h3>
        <#else>
            <h3><i>Работник</i></h3>
        </#if>
        <h3>Баланс: <i>${user.accountBalance}</i></h3>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="input_exit" type="submit" value="Выйти"/><br>
        </form>
        <div class="form_wrapper">
            <form action="/profile" method="get">
                <input class="input_exit" type="submit" value="Личный кабинет"/>
            </form>
            <#if user.isAdmin()>
                <form action="/admin" method="get">
                    <input class="input_exit" type="submit" value="Панель администратора"/>
                </form>
            </#if>
            <#if user.isAccountant()>
                <form action="/employees" method="get">
                    <input class="input_exit" type="submit" value="Сотрудники"/>
                </form>
            </#if>
            <hr class="big_block">
            <#if user.isEmployee()>
                <h3>Мои пополнения</h3>
            <#else>
                <h3>Пополнения</h3>
            </#if>
            <form action="/" method="get">
                Поиск по сумме пополнения: <input type="text" name="textSummary"><br>
                <input type="submit" value="Поиск"/>
            </form>
            <#list empTransactions as transaction>
                <#if !user.isEmployee()>
                    <div>
                        <p><b>${transaction.summary}</b> ${transaction.recipient.name} | <a class="moreinfo" href="/transaction/${transaction.id}">Подробнее</a></p>
                    </div>
                <#else>
                    <#if user.id == transaction.recipient.id>
                        <div>
                            <p><b>${transaction.summary}</b> ${transaction.recipient.name} | <a class="moreinfo" href="/transaction/${transaction.id}">Подробнее</a></p>
                        </div>
                    </#if>
                </#if>
            <#else>
                <h3>Пополнений нет</h3>
            </#list>
        </div>
        <hr>

        <#if !user.isEmployee()>
            <h3 class="main_transaction">Перевести деньги</h3>
            <form action="/transaction/create" method="post">
                Сумма: <input type="text" name="textSummary"/><br><br>
                ID Получателя: <input type="number" name="recipientId"/><br><br>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input class="input_main_transaction" type="submit" value="Перевести">
            </form>
        </#if>
    <#else>
        <form action="/login" method="post">
            <input class="input_exit" type="submit" value="Войти в аккаунт"/>
        </form>
    </#if>
    <#if message?has_content>
        <h1 style="color: red">${message}</h1>
    </#if>
</div>
</body>
</html>