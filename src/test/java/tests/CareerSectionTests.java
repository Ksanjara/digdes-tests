package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@DisplayName("Раздел \"Карьера\"")
@Owner("Kseniia Kuznetsova")
@Feature("Тестирование раздела \"Карьера\" сайта компании Digital Design")
@Tags({@Tag("Regression"), @Tag("ui")})
public class CareerSectionTests extends TestBase {
    @DisplayName("Карьера: Наша команда. Страница содержит видеообращение генерального директора")
    @Story("Тестирование страницы \"Наша команда\"")
    @Severity(SeverityLevel.TRIVIAL)
    @Tag("Positive")
    @Test
    void ceoVideoExistsTest() {
        mainPage.openMainPage()
                .openCareerPoint("Наша команда");
        careerPage.checkVideoFromCeo();
    }

    @DisplayName("Карьера: Наша команда. Проверка полей формы обратной связи")
    @Story("Тестирование страницы \"Наша команда\"")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Positive")
    @Test
    void careerFormFieldsTest() {
        mainPage.openMainPage()
                .openCareerPoint("Наша команда");
        careerPage.checkCareerFormInputs();
    }
}
