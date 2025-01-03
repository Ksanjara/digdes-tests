<p align="center"> 
<img align="center" src="media/logo/logo-dd.svg" title="DigDes" width="30%"/>
</p>

# Проект по автоматизации тестовых сценариев для сайта компании [Digital Design](https://digdes.ru/)
## :pushpin: Содержание:

- Использованный стек технологий
- Запуск автотестов
- Сборка в Jenkins
- Пример Allure-отчета
- Уведомления в Telegram с использованием бота
- Видео примера запуска тестов в Selenoid

## :computer: Использованный стек технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> 
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> 
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>   
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>   
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>   
<a href="https://web.telegram.org/k//"><img src="media/logo/Telegram.svg" width="50" height="50"  alt="IDEA"/></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean regression_test
```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.

```
gradle
clean
regression_test
-DremoteUrl=https://${REMOTE_LOGIN}:${REMOTE_PASSWORD}@${REMOTE_URL}/wd/hub
-DbrowserName=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
```

### Параметры сборки

* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.
* <code>REMOTE_LOGIN</code> и <code>REMOTE_PASSWORD</code> – учетные данные пользователя для удаленного сервера.

## <img src="media/logo/Jenkins.svg" title="Jenkins" width="4%"/> [Сборка](https://jenkins.autotests.cloud/job/C31-ksanjara-java_14_digdes_tests/) в Jenkins
<p align="center">
<img title="Jenkins Build" src="media/screens/JenkinsBuild.png">
</p>

## <img src="media/logo/Allure_Report.svg" title="Allure Report" width="4%"/> [Пример](https://jenkins.autotests.cloud/job/C31-ksanjara-java_14_digdes_tests/13/allure/) Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="media/screens/allureReport.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/screens/ResultTest.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/notification.png">
</p>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>
