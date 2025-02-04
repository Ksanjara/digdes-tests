package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LibraryPage {
    private final SelenideElement libraryListBlock = $("div#library-list"),
            documentsBlock = $("div#library-list").$("div.items");

    @Step("Проверить, что документы технических заданий отображаются на странице")
    public LibraryPage checkDocumentsExistence() {
        libraryListBlock.shouldHave(text("Примеры технических заданий для наших решений"));
        documentsBlock.shouldBe(not(empty));

        return this;
    }
}
