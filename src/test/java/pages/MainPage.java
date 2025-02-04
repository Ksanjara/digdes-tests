package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement menuBar = $("#dd-menu"),
            menuDropdown = $("li.dropdown.open"),
            aboutCompanyButton = $("#dd-menu").$(byText("О компании")),
            nlabButton = $x("//*[@id=\"dd-menu\"]/ul/li[3]"),
            careerButton = $("#dd-menu").$(byText("Карьера"));

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("");

        return this;
    }

    @Step("Открыть раздел О компании в верхнем меню и нажать раздел {0}")
    public MainPage openCompanyPoint(String buttonName) {
        aboutCompanyButton.click();
        menuDropdown.$(byText(buttonName)).click();

        return this;
    }

    @Step("Открыть раздел Научная лаборатория в верхнем меню")
    public MainPage openNlabDropdown() {
        nlabButton.click();

        return this;
    }

    @Step("Проверить список пунктов выпадающего меню раздела Научная лаборатория ")
    public MainPage checkDropdownNlabPoints() {
        menuDropdown.shouldHave(text("О научной лаборатории"),
                text("Автоматическая проверка документов"), text("Интеллектуальная обработка корреспонденции"),
                text("Прогнозирование водно-энергетических режимов"));

        return this;
    }

    @Step("Открыть раздел Карьера в верхнем меню и нажать раздел {0}")
    public MainPage openCareerPoint(String buttonName) {
        careerButton.click();
        menuDropdown.$(byText(buttonName)).click();

        return this;
    }

}
