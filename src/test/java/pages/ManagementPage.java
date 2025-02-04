package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ManagementPage {
    private final SelenideElement employeeCard = $("div#management-managers"),
            ceoModalTitle = $("div#modal-m-varfolomeev").$("h4.modal-title");
    private final String ceoPositionName = "Генеральный директор компании Digital Design";

    @Step("Открыть карточку с ФИО генерального директора")
    public ManagementPage openCeoModalCard() {
        employeeCard.$(byText(ceoPositionName)).click();

        return this;
    }

    @Step("Проверить отображение ФИО генерального директора в модальном окне")
    public ManagementPage checkCeoName(String ceoName) {
        ceoModalTitle.shouldHave(text(ceoName), text(ceoPositionName));

        return this;
    }
}
