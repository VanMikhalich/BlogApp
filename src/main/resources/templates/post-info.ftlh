<#import "blocks/template.ftlh" as t>
<@t.template user>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Info</title>
</head>
<body>
<h2>Информация о посте:</h2>
    <div class="card" style="width: 18rem;">
        <img src="/images/${post.image.id}" class="card-img-top">
        <div class="card-body">
            <h5 class="card-title">${post.title}</h5>
            <p class="card-text">${post.description}</p>
            <#if show>
                <a href="/update/${post.id}" class="btn btn-outline-primary">Изменить</a>
                <form action="/delete/${post.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-outline-danger">Удалить</button>
                </form>
            </#if>
        </div>
    </div>

    <h2>Комментарии:</h2>
    <div class="form-floating">
        <form action="/create_comment/${post.id}" method="post">
            <textarea type="text" name="text" class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" class="btn btn-outline-primary" value="Добавить комментарий"/>
        </form>
    </div>
<hr>

<#list post.comments as comment>
    <div class="card">
        <div class="card-header">
            ${comment.user.username}
        </div>
        <div class="card-body">
            <p><b>${comment.text}</b></p>
        </div>
    </div>
    <#if comment.show>
        <a href="/update_comment/${comment.id}"><button type="button" class="btn btn-outline-primary"> Изменить </button></a>
        <form action="/delete_comment/${comment.id}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-outline-danger">Удалить</button>
        </form>
        <br>
    </#if>
<#else>
    <h3>Комментариев нет</h3>
</#list>

</body>
</html>
</@t.template>