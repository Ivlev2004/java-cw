<!DOCTYPE html>
<html>
<head>
    <title>PayDay</title>
    <link rel="stylesheet" href="static/cssFile.css">
</head>
<body>
<div class="container">
    <h1 class="bg_color">Payday</h1>
    <h4>Регистрация</h4>
    <form action="/registration" method="post">
        Имя пользователя: <input type="text" name="name"><br><br>
        Эл. почта: <input type="email" name="email"><br><br>
        Номер телефона: <input type="text" name="phoneNumber"><br><br>
        Пароль: <input type="password" name="password"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input class="btn_registration" type="submit" value="Зарегистрироваться"/>
    </form>
    <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
    </#if>
</div>
</body>
</html>