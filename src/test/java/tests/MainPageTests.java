package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("Smoke"), @Tag("ui")})
@DisplayName("Главная страница")
@Owner("Kseniia Kuznetsova")
@Feature("Тестирование главной страницы сайта компании Digital Design")
public class MainPageTests extends TestBase {

    @DisplayName("Главная страница: Научная лаборатория. Проверка пунктов выпадающего меню")
    @Story("Тестирование меню-хедера на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Positive")
    @Test
    void checkScienceLabMenuTest() {
        mainPage.openMainPage()
                .openNlabDropdown()
                .checkDropdownNlabPoints();
    }

    @DisplayName("Главная страница: О компании. Проверка пунктов выпадающего меню")
    @Story("Тестирование меню-хедера на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Positive")
    @Test
    void checkAboutCompanyMenuTest() {
        mainPage.openMainPage()
                .openCompanyDropdown()
                .checkDropdownCompanyPoints();
    }

}
