package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CareerSectionTests extends TestBase {
    @DisplayName("Карьера: Наша команда. Страница содержит видеообращение генерального директора")
    @Test
    void ceoVideoExistsTest() {
        mainPage.openMainPage()
                .openCareerPoint("Наша команда");
        careerPage.checkVideoFromCeo();
    }

    @Tag("not ready")
    @DisplayName("Карьера: Наша команда. Проверка полей формы обратной связи")
    @Test
    void careerFormFieldsTest() {
        mainPage.openMainPage()
                .openCareerPoint("Наша команда");
        careerPage.checkCareerFormInputs();
    }
}
