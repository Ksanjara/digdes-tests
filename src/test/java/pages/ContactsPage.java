package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactsPage {
    private final SelenideElement officesBlock = $("#contacts-offices"),
            firstCardCityInfo = $$("div.item").get(0).$("div.city"),
            firstCardPostalCodeInfo = $$("div.item").get(0).$("[itemprop=postalCode]"),
            firstCardStreetAddressInfo = $$("div.item").get(0).$("[itemprop=streetAddress]"),
            firstCardOpeningHoursInfo = $$("div.item").get(0).$("[itemprop=openingHours]");

    @Step("Проверить наличие офиса в городе {0}")
    public ContactsPage checkOfficeInCity(String cityName) {
        officesBlock.shouldHave(text(cityName));
        return this;
    }

    @Step("Проверить информацию в карточке первого офиса")
    public ContactsPage checkFirstOfficeCardCityData(String city, String postalCode, String streetAddress,
                                                     String openingHours) {
        firstCardCityInfo.shouldHave(text(city));
        firstCardPostalCodeInfo.shouldHave(text(postalCode));
        firstCardStreetAddressInfo.shouldHave(text(streetAddress));
        firstCardOpeningHoursInfo.shouldHave(text(openingHours));
        return this;
    }

}
