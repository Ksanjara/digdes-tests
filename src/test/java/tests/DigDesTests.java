package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("Regression")
public class DigDesTests extends TestBase{

    @DisplayName("О компании: Библиотека технических заданий содержит список документов")
    @Test
    void techLibraryContainsDocumentsTest(){
        step("Открыть главную страницу", () -> {
            open("");
        });
        step("Перейти в раздел О компании->Библиотека технических заданий", () -> {
            $("#dd-menu").$(byText("О компании")).click();
            $("li.dropdown.open").$(byText("Библиотека технических заданий")).click();
        });
        step("Найти список документов", () -> {
            $("div#library-list").shouldHave(text("Примеры технических заданий для наших решений"));
            $("div#library-list").$("div.items").shouldBe(not(empty));
        });
    }

    @Tag("Smoke")
    @DisplayName("О компании: Контакты. Проверка данных офиса в Санкт-Петербурге")
    @Test
    void spbOfficeDataCheckingTest(){
        step("Открыть главную страницу", () -> {
            open("");
        });
        step("Перейти в раздел О компании->Контакты", () -> {
            $("#dd-menu").$(byText("О компании")).click();
            $("li.dropdown.open").$(byText("Контакты")).click();
        });
        step("Проверить данные офиса в г.Санкт-Петербург", () -> {
            $("#contacts-offices").shouldHave(text("Санкт-Петербург"));
            $$("div.item").get(0).$("div.city").shouldHave(text("Санкт-Петербург"));
            $$("div.item").get(0).$("[itemprop=postalCode]").shouldHave(text("199178"));
            $$("div.item").get(0).$("[itemprop=streetAddress]").shouldHave(text("наб. реки Смоленки, д. 33"));
            $$("div.item").get(0).$("[itemprop=openingHours]").shouldHave(text("Пн-Пт 10:00-19:00"));
        });
    }

    @DisplayName("О компании: Руководство. Проверка отображения генерального директора")
    @Test
    void checkCeoNameTest(){
        step("Открыть главную страницу", () -> {
            open("");
        });
        step("Перейти в раздел О компании->Руководство", () -> {
            $("#dd-menu").$(byText("О компании")).click();
            $("li.dropdown.open").$(byText("Руководство")).click();
        });
        step("Кликнуть карточку с ФИО генерального директора", () -> {
            $("div#management-managers").$(byText("Генеральный директор компании Digital Design")).click();
        });
        step("Проверить отображение ФИО генерального директора в модальном окне", () -> {
            $("div#modal-m-varfolomeev").$("h4.modal-title").shouldHave(text("Антон Владиславович Варфоломеев"), text("Генеральный директор компании Digital Design"));
        });
    }

    @Tag("Smoke")
    @DisplayName("Научная лаборатория: Проверка пунктов выпадающего меню")
    @Test
    void checkScienceLabMenuTest(){
        step("Открыть главную страницу", () -> {
            open("");
        });
        step("Кликнуть раздел Научная лаборатория", () -> {
            $("#dd-menu").$(byText("Научная лаборатория")).click();
        });
        step("Проверить список пунктов", () -> {
            $("li.dropdown.open").shouldHave(text("О научной лаборатории"),
                    text("Автоматическая проверка документов"), text("Интеллектуальная обработка корреспонденции"),
                    text("Прогнозирование водно-энергетических режимов"));
        });
    }

    @DisplayName("Карьера: Наша команда. Страница содержит видеообращение генерального директора")
    @Test
    void ceoVideoExistsTest(){
        step("Открыть главную страницу", () -> {
            open("");
        });
        step("Перейти в раздел Карьера->Наша команда", () -> {
            $("#dd-menu").$(byText("Карьера")).click();
            $("li.dropdown.open").$(byText("Наша команда")).click();
        });
        step("Проверить наличие видеообращения", () -> {
            $("div#career-new-video").shouldHave(text("Обращение генерального директора")).scrollTo();
            $("div.adaptive-video").shouldBe(visible);
        });
    }
}
