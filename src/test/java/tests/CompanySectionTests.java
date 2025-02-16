package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Раздел \"О компании\"")
@Owner("Kseniia Kuznetsova")
@Feature("Тестирование раздела \"О компании\" сайта компании Digital Design")
@Tags({@Tag("Regression"), @Tag("ui")})
public class CompanySectionTests extends TestBase {

    @DisplayName("О компании: Библиотека технических заданий содержит список документов")
    @Story("Тестирование страницы \"Библиотека технических заданий\"")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Positive")
    @Test
    void techLibraryContainsDocumentsTest() {
        mainPage.openMainPage()
                .openCompanyPoint("Библиотека технических заданий");
        libraryPage.checkDocumentsExistence();
    }


    @ValueSource(strings = {
            "Санкт-Петербург", "Москва", "Саратов"
    })
    @ParameterizedTest(name = "О компании: Контакты. Проверка наличия офиса в городе {0}")
    @Story("Тестирование страницы контактов")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("Positive"), @Tag("Smoke")})
    void spbOfficeDataCheckingTest(String cityName) {
        mainPage.openMainPage()
                .openCompanyPoint("Контакты");
        contactsPage.checkOfficeInCity(cityName);
    }


    @DisplayName("О компании: Контакты. Проверка данных офиса в Санкт-Петербурге")
    @Story("Тестирование страницы контактов")
    @Severity(SeverityLevel.MINOR)
    @Tags({@Tag("Positive"), @Tag("Smoke")})
    @Test
    void spbOfficeDataCheckingTest() {
        mainPage.openMainPage()
                .openCompanyPoint("Контакты");
        contactsPage.checkOfficeInCity("Санкт-Петербург")
                .checkFirstOfficeCardCityData("Санкт-Петербург", "199178",
                        "наб. реки Смоленки, д. 33", "Пн-Пт 10:00-19:00");
    }

    @DisplayName("О компании: Руководство. Проверка отображения генерального директора")
    @Story("Тестирование страницы \"Руководство\"")
    @Severity(SeverityLevel.MINOR)
    @Tag("Positive")
    @Test
    void checkCeoNameTest() {
        mainPage.openMainPage()
                .openCompanyPoint("Руководство");
        managementPage.openCeoModalCard()
                .checkCeoName("Антон Владиславович Варфоломеев");
    }

}
