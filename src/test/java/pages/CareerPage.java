package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CareerPage {
    private final SelenideElement videoBlock = $("div#career-new-video"),
            video = $("div.adaptive-video"),
            inputName = $(By.name("data[firstname]")),
            inputLastName = $(By.name("data[lastname]")),
            inputPhone = $(By.name("data[phone]")),
            inputEmail = $(By.name("data[email]")),
            inputVacancy = $(By.name("data[vacancy]")),
            inputCvFile = $("#resume-file"),
            labelCvFile = $("label[for='resume-file']"),
            inputMessage = $(By.name("data[comment]"));

    @Step("Проверить наличие видеообращения генерального директора")
    public CareerPage checkVideoFromCeo() {
        videoBlock.shouldHave(text("Обращение генерального директора"));
        video.shouldBe(visible);

        return this;
    }

    @Step("Проверить инпуты обратной связи для резюме")
    public CareerPage checkCareerFormInputs() {
        inputName.shouldHave(attribute("placeholder", "Имя *")).shouldBe(visible);
        inputLastName.shouldHave(attribute("placeholder", "Фамилия *")).shouldBe(visible);
        inputPhone.shouldHave(attribute("placeholder", "Телефон *")).shouldBe(visible);
        inputEmail.shouldHave(attribute("placeholder", "Почта *")).shouldBe(visible);
        inputLastName.shouldHave(attribute("placeholder", "Фамилия *")).shouldBe(visible);
        inputVacancy.shouldHave(attribute("placeholder", "Интересующая вакансия")).shouldBe(visible);
        inputCvFile.shouldBe(interactable);
        labelCvFile.shouldHave(text("Прикрепить резюме"));
        inputMessage.shouldHave(attribute("placeholder", "Сообщение")).shouldBe(visible);

        return this;
    }

    @Step("Заполнить только необязательные поля формы обратной связи")
    public CareerPage fillNonRequiredFieldsOnly(String desiredPosition, String message) {
        inputVacancy.setValue(desiredPosition);
        inputMessage.setValue(message);

        return this;
    }
}
