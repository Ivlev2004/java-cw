<!DOCTYPE html>
<html>
<head>
    <title>PayDay</title>
    <link rel="stylesheet" href="/static/css/my-reservations.css">
</head>
<body>
<div class="container">
    <h1 class="bg_color">Payday</h1>
    <hr>
    <h4 class="big_block">Переводы сотруднику ${user.name}</h4>
    <hr class="no_hr">
    <div>
        <#list transactions as reservation>
            <a href="/transaction/${reservation.id}">
                <div>
                    <div>
                        <h3>Сумма: ${reservation.summary}</h3>
                        <p>Дата: ${reservation.dateOfTransaction}</p><br>
                    </div>
                </div>
            </a>
        <#else>

            <h1 style="text-align: center">Не найдено</h1>
        </#list>
    </div>
</div>
</div>
</body>
</html>