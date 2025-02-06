<p align="center"> 
<img align="center" src="media/logo/logo-dd.svg" title="DigDes" width="30%"/>
</p>

# Проект по автоматизации тестовых сценариев для сайта компании [Digital Design](https://digdes.ru/)
## :page_with_curl: Содержание:

- <a href="#tools">Использованный стек технологий</a>
- <a href="#launch"> Запуск автотестов </a>
- <a href="#build"> Сборка в Jenkins </a>
- <a href="#allureReport"> Пример Allure-отчета </a>
- <a href="#tg"> Уведомления в Telegram с использованием бота </a>
- <a href="#allureOps"> Интеграция с Allure TestOps </a>
- <a href="#selenoid"> Видео примера запуска тестов в Selenoid </a>

<a id="tools"></a>
## 🔨 Использованный стек технологий

| Java                                                                                                    | IntelliJ  <br>  Idea                                                                                                      | GitHub                                                                                                    | JUnit 5                                                                                                          | Gradle                                                                                                    | Selenoid                                                                                                                 | Allure <br> Report                                                                                                               | Jenkins                                                                                                         | Selenide                                                                                                                           | Telegram                                                                                                           |                                                                                               Allure <br> TestOps |
|:--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------:|
| <a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="media/logo/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://ru.selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50" alt="Selenide" title="Selenide"/></a> | <a href="https://web.telegram.org/"><img src="media/logo/Telegram.svg" width="50" height="50" alt="Telegram"/></a> | <a href="https://qameta.io/"><img src="media/logo/AllureTestOps.svg" width="50" height="50" alt="Allure_TO"/></a> |


- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Также реализована интеграция с `Allure TestOps` для тестовой документации с возможностью сборки тестовых прогонов и их запуска.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

<a id="launch"></a>
## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
Локально:
```
gradle clean test -Denv=local
```
При выполнении команды тесты запустятся локально.

Удалённо:
```
gradle clean test -Denv=remote
```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.

<a id="build"></a>
## <img src="media/logo/Jenkins.svg" title="Jenkins" width="4%"/> [Сборка](https://jenkins.autotests.cloud/job/C31-ksanjara-java_14_digdes_tests/) в Jenkins
<p align="center">
<img title="Jenkins Build" src="media/screens/JenkinsBuild.png">
</p>

<a id="allureReport"></a>
## <img src="media/logo/Allure_Report.svg" title="Allure Report" width="4%"/> [Пример](https://jenkins.autotests.cloud/job/C31-ksanjara-java_14_digdes_tests/13/allure/) Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="media/screens/allureReport.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/screens/ResultTest.png">
</p>

<a id="tg"></a>
## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/notification.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4545/test-cases?treeId=0)

### Доска
<p align="center">
<img src="media/screens/testops_dashboard.png">
</p>

### Тест-кейсы
<p align="center">
<img src="media/screens/tc_auto.png">
</p>

### Пример мануального тест-кейса
<p align="center">
<img src="media/screens/tc_manual.png">
</p>

### Запуски сборок
<p align="center">
<img src="media/screens/tc_runs.png">
</p>

### Запуск выбранных тестов из Allure TestOps
<p align="center">
<img src="media/screens/tc_create_run.png">
</p>

<a id="selenoid"></a>
## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>
