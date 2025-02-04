package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CareerPage {
    private final SelenideElement videoBlock = $("div#career-new-video"),
            video = $("div.adaptive-video"),
            careerFormBlock = $("#career-form"),
            careerFormTitle = $("#career-form").$(".p-career-title"),
            inputName = $(By.name("data[firstname]")),
            inputLastName = $(By.name("data[lastname]")),
            inputPhone = $(By.name("data[phone]")),
            inputEmail = $(By.name("data[email]")),
            inputVacancy = $(By.name("data[vacancy]")),
            inputCvFile = $("#resume-file"),
            inputMessage = $(By.name("data[comment]")),
            submitButton = $("div.field-button").$("[type=submit]");

    @Step("Проверить наличие видеообращения генерального директора")
    public CareerPage checkVideoFromCeo() {
        videoBlock.shouldHave(text("Обращение генерального директора"));
        video.shouldBe(visible);

        return this;
    }

    @Step("Проверить инпуты обратной связи для резюме")
    public CareerPage checkCareerFormInputs() {
        inputName.shouldHave(cssValue("placeholder", "Имя *")).shouldBe(visible);
        inputLastName.shouldHave(cssValue("placeholder", "Фамилия *")).shouldBe(visible);
        inputPhone.shouldHave(cssValue("placeholder", "Телефон *")).shouldBe(visible);
        inputEmail.shouldHave(cssValue("placeholder", "Почта *")).shouldBe(visible);
        inputLastName.shouldHave(cssValue("placeholder", "Фамилия *")).shouldBe(visible);
        inputVacancy.shouldHave(cssValue("placeholder", "Интересующая вакансия")).shouldBe(visible);
        inputCvFile.shouldBe(interactable).shouldHave(text("Прикрепить резюме"));
        inputMessage.shouldHave(cssValue("placeholder", "Сообщение")).shouldBe(visible);

        return this;
    }
}
