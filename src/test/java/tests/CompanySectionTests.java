package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Regression")
public class CompanySectionTests extends TestBase {

    @DisplayName("О компании: Библиотека технических заданий содержит список документов")
    @Test
    void techLibraryContainsDocumentsTest() {
        mainPage.openMainPage()
                .openCompanyPoint("Библиотека технических заданий");
        libraryPage.checkDocumentsExistence();
    }

    @Tag("Smoke")
    @DisplayName("О компании: Контакты. Проверка данных офиса в Санкт-Петербурге")
    @Test
    void spbOfficeDataCheckingTest() {
        mainPage.openMainPage()
                .openCompanyPoint("Контакты");
        contactsPage.checkOfficeInCity("Санкт-Петербург")
                .checkFirstOfficeCardCityData("Санкт-Петербург", "199178",
                        "наб. реки Смоленки, д. 33", "Пн-Пт 10:00-19:00");
    }

    @DisplayName("О компании: Руководство. Проверка отображения генерального директора")
    @Test
    void checkCeoNameTest() {
        mainPage.openMainPage()
                .openCompanyPoint("Руководство");
        managementPage.openCeoModalCard()
                .checkCeoName("Антон Владиславович Варфоломеев");
    }

}
