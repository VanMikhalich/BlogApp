<#import "blocks/template.ftlh" as t>
<@t.template user>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Update</title>
</head>
<body>
<h2>Изменить пост:</h2>
<form action="/update" enctype="multipart/form-data" method="post">
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Название поста</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" name="title" value="${post.title}">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Описание поста</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" name="description" value="${post.description}">
    </div>
    <div class="input-group mb-3">
        <input type="file" name="file" class="form-control" id="inputGroupFile02">
    </div>
    <input type="hidden" name="id" value="${post.id}">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" class="btn btn-outline-primary" value="Изменить пост"/>
</form>
</body>
</html>
</@t.template>