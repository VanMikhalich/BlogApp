<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Регистрация</h1>
<br>
<form action="/registration" method="post">
    <div class="form-group">
        <label for="nikName">Имя пользователя</label>
        <input type="text" class="form-control <#if usernameError??>is-invalid</#if>" id="username" name="username">
        <#if usernameError??>
            <div id="validationServer03Feedback" class="invalid-feedback">
                ${usernameError}
            </div>
        </#if>
    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <input type="password" class="form-control <#if usernameError??>is-invalid</#if>" id="password" name="password">
        <#if passwordError??>
            <div id="validationServer03Feedback" class="invalid-feedback">
                ${passwordError}
            </div>
        </#if>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit" style="width: 100%" class="btn btn-dark">Зарегистрироваться</button>
    <hr>
    <h3>Уже зарегистрированы? <a href="/login">Войти</a></h3>
</form>
</@t.template>