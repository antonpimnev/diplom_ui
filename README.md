## Учебный проект по автоматизации тестирования (Web UI)

### Веб сайт <a target="_blank" href="https://sturmuniform.ru/">Интернет-магазин sturmuniform.ru</a>

<p align="center">
<img title="Интернет-магазин sturmuniform.ru" name="logo" src="images/screens/logo.png">
</p>

## Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins)
- Allure-отчет
- Интеграция с Allure TestOps
- Уведомление в Telegram о результатах запуска тестов
- Видео пример прохождения тестов

## Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## Список проверок, реализованных в автотестах

- [x] Проверка наличия логотипа на главной странице
- [x] Проверка меню на главной странице
- [x] Проверка наличия подкатегорий в категории меню
- [x] Проверка результатов быстрого поиска
- [x] Проверка что товар соответствует заявленной цене
- [x] Проверка отображения полей на странице расширенного поиска
- [x] Проверка результатов расширенный поиска
- [x] Проверка добавление товара в корзину
- [x] Проверка удаления товара из корзины

## Запуск тестов

###  Локальный запуск :
Пример командной строки:
```bash
gradle clean ui
```
Получение отчёта:
```bash
allure serve build/allure-results
```

###  Удаленный запуск (в Jenkins):
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-antonpimnev-diplom-ui/">проект</a>

![This is an image](/images/screens/Jenkins1.png)

2. Выбрать пункт **Собрать с параметрами**
3. В случае необходимости изменить параметры, выбрав значения из выпадающих списков
4. Нажать **Собрать**

![This is an image](/images/screens/Jenkins2.png)
![This is an image](/images/screens/Jenkins3.png)

5. Результат запуска сборки можно посмотреть в отчёте Allure

![This is an image](/images/screens/Jenkins4.png)

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-antonpimnev-diplom-ui/2/allure/">Allure report</a>

###  Главная

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/Allure_Report1.png">
</p>

###  Тесты

<p align="center">
<img title="Allure Tests" src="images/screens/Allure_Report2.png">
</p>

###  Графики

<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_Report3.png">
</p>


## <img src="images/logo/Allure_TO.svg" width="25" height="25"  alt="Allure"/></a> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/20028">Allure TestOps</a>
### Общий список тест-кейсов:
<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_TestOps-TC.png">
</p>

### Dashboard с общими результатами тестирования
<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_TestOps-Dashboard.png">
</p>

### Пример отчёта выполнения одного из запусков
<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_TestOps-Launch.png">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram о результатах выполнения запуска тестов

<p align="center">
<img title="Уведомление в Telegram" src="images/screens/TelegramNotification.png" >
</p>

## <img src="images/logo/Selenoid.svg" width="25" height="25"  alt="Selenoid"/></a> Видео прохождения тестов
<p align="center">
<img src="/images/video/videoUItests.gif" alt="video"/></a>
</p>

[Вернуться к оглавлению ⬆](#logo)
