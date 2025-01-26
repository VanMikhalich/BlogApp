# BlogApp
![Главная картинка](readme_assets/titleGif.gif)

---
## Описание
Веб-приложение написано при помощи **Spring Boot** и **Spring Security**.
Приложение использует валидацию полей и позволяет создавать, изменять, удалять и просматривать посты, созданные пользователями.

При помощи Spring Security создано безопасное хэширование паролей, а также _csrf токены.

Приложение использует PostgreSQL как базу данных и может быть запущено с помощью Docker.

<hr>

### Требования
Для запуска проекта необходимо:
- [PostgreSQL](https://www.postgresql.org/download/)
- [Docker](https://www.docker.com/products/docker-desktop) (если хотите запустить с использованием Docker)
- [Maven](https://maven.apache.org/download.cgi)

### Начало работы
1. **Настройка базы данных:**
    В файле ``application.properties`` необходимо установить логин и пароль для подключения к базе данных.

    В строке ``spring.datasource.username=postgres`` устанавливаем имя пользователя.

    В строке ``spring.datasource.password=admin`` устанавливаем пароль.

2. **Запуск проекта без Docker:**
    - Скачайте и установите [PostgreSQL](https://www.postgresql.org/download/).
    - Создайте базу данных и настройте подключение к ней.
    - Откройте приложение по адресу `localhost:8080` в браузере.

3. **Запуск проекта с Docker:**
    - Убедитесь, что у вас установлен Docker и Docker Compose.
    - В корне проекта создайте контейнеры с помощью Docker Compose:
    ```bash
    docker-compose up --build
    ```
    Это создаст два контейнера:
    - **PostgreSQL** для хранения данных
    - **Spring Boot** приложение, которое будет доступно по адресу `localhost:8080`
