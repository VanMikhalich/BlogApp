<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Авторизация</h1>
<hr>
<form action="/login" method="post">
    <div class="form-group">
        <label for="email">Имя пользователя</label>
        <input type="text" class="form-control <#if RequestParameters.error??>is-invalid</#if>" id="email" name="username">
        <#if RequestParameters.error??>
            <div id="email" class="invalid-feedback">
                Неверный логин
            </div>
        </#if>
    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <input type="password" class="form-control <#if RequestParameters.error??>is-invalid</#if>" id="password" name="password">
        <#if RequestParameters.error??>
            <div id="password" class="invalid-feedback">
                Неверный пароль
            </div>
        </#if>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit" style="width: 100%" class="btn btn-dark">Войти</button>
    <hr>
    <h3>Еще не зарегистрированы? <a href="/registration">Зарегаться</a></h3>
</form>
</@t.template>