<#import "blocks/template.ftlh" as t>
<@t.template user>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Posts</title>
</head>
<body>
<h1>Posts</h1>
<h3>Привет, <b>${user.username}!</b></h3>
<hr>

<#list posts as post>
    <div class="card">
        <div class="card-header">
            ${post.user.username}
        </div>
        <div class="card-body">
            <h5 class="card-title">${post.title}</h5>
            <p class="card-text">${post.description}</p>
            <a href="/post/${post.id}">Подробнее..</a>
        </div>
    </div>
<#else>
    <h3 align="center">Постов нет</h3>
</#list>
<hr>
<h2>Создать новый пост:</h2>
<form action="/create" enctype="multipart/form-data" method="post" >
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Название поста</label>
        <input type="text" class="form-control <#if titleError??>is-invalid</#if>" id="exampleFormControlInput1" name="title">
        <#if titleError??>
            <div id="validationServer03Feedback" class="invalid-feedback">
                ${titleError}
            </div>
        </#if>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Описание поста</label>
        <textarea type="text" class="form-control <#if descriptionError??>is-invalid</#if>" id="exampleFormControlTextarea1" rows="3" name="description"></textarea>
        <#if descriptionError??>
            <div id="validationServer03Feedback" class="invalid-feedback">
                ${descriptionError}
            </div>
        </#if>
    </div>
    <div class="input-group mb-3">
        <input type="file" name="file" class="form-control" id="inputGroupFile02">
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить пост"/>
</form>
</body>
</html>
</@t.template>