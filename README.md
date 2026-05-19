- Разработал фреймворк для автоматизированного UI-тестирования веб-приложения;
- Реализовал автотесты на основе требований;
- Настроил систему отчётности Allure c автоматическим захватом скриншотов при падении тестов;
- Реализовал параметризацию тестов;
- Разработал механизм автоматического перезапуска упавших тестов с настройкой повторных попыток;
- Настроил параллельный запуск тестов;
- Реализовал работу с cookies.



## Настройка файла credentials.local.properties

Создайте файл credentials.local.properties в папке src/test/resources

- Для теста сайта https://www.sql-ex.ru вставьте в файл credentials.local.properties логин и пароль в переменные:

        sql-ex.login=<>
        sql-ex.password=<>
- Для теста сайта https://www.httpwatch.com/httpgallery/authentication/#showExample9 вставьте 
в файл credentials.local.properties логин и пароль в переменные:
        
        httpwatch.login=<>
        httpwatch.password=<>
=======