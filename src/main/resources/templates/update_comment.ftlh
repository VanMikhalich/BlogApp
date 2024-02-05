<#import "blocks/template.ftlh" as t>
<@t.template user>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Update</title>
</head>
<body>
<h2>Изменить комментарий:</h2><br>
<form action="/update_comment" method="post">
    <input type="hidden" name="id" value="${comment.id}">
    <div class="form-floating">
        <input type="text" name="text" id="floatingTextarea2" value="${comment.text}" required>
    </div><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" class="btn btn-outline-primary" value="Изменить комментарий"/>
</form>
</body>
</html>
</@t.template>