# BlogApp
![Главная картинка](readme_assets/titleGif.gif)

---
## Описание
Веб-приложение написано при помощи **Spring Boot** и **Spring Security**.
Приложение использует валидацию полей и позволяет создавать, изменять, удалять и просматривать посты, созданные пользователями.

При помощи Spring Security создано безопасное хэширование паролей, а также _csrf токены
<hr>

### Требования
Для запуска проекта необходим [MySQL](https://dev.mysql.com/downloads/installer "Вы можете скачать, перейдя по ссылке")
и [Maven](https://dev.mysql.com/downloads/installer)
### Начало работы
В файле ``application.properties`` необходимо установить логин и пароль от БД, а также указать название БД
1. В строке ``spring.datasource.username=root`` устанавливаем имя пользователя
2. В строке ``spring.datasource.password=admin`` устанавливаем пароль
3. В строке ``spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/spring_boot?useSSL=false&allowPublicKeyRetrieval=true`` вместо **spring_boot** указываем название БД
* Откройте ``localhost:8080`` в браузере, чтобы увидеть само приложение
