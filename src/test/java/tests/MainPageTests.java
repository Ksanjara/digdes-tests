package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MainPageTests extends TestBase {
    @Tag("Smoke")
    @DisplayName("Главная страница: Научная лаборатория. Проверка пунктов выпадающего меню")
    @Test
    void checkScienceLabMenuTest() {
        mainPage.openMainPage()
                .openNlabDropdown()
                .checkDropdownNlabPoints();
    }
}
