package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfig;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

public class TestBase {
    private static final WebConfig webConfig = ConfigReader.Instance.read();
    MainPage mainPage = new MainPage();
    LibraryPage libraryPage = new LibraryPage();
    ContactsPage contactsPage = new ContactsPage();
    ManagementPage managementPage = new ManagementPage();
    CareerPage careerPage = new CareerPage();

    @BeforeAll
    static void preconditionsForAllTests() {
        ProjectConfig projectConfiguration = new ProjectConfig(webConfig);
        projectConfiguration.webConfig();
    }

    @BeforeEach
    void preconditionForEachTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.closeWebDriver();

    }
}
