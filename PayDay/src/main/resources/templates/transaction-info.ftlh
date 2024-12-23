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
    <h3>Подробная информация о переводе</h3>
    <b>ID: </b>${transaction.id}<br>
    <b>Сумма: </b>${transaction.summary}<br>
    <b>Дата: </b>${transaction.dateOfTransaction}<br>
    <b>Отправитель: </b>${transaction.sender.name}<br>
</div>
</body>
</html>