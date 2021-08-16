import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


@Epic("saucedemo.com Tests")
@Feature("Login Tests")
@DisplayName("Login Tests")
public class LoginTest {

    LoginPage loginPage = new LoginPage();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


    @Test
    @DisplayName("Login test")
    @Description("Test reproduce log in with correct user")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("1101")
    public void shouldLogin() {
        loginPage.login("standard_use", "secret_sauce");

        loginPage.checkLogIn();
    }

    @Test
    @DisplayName("Login test with incorrect user")
    @Description("Test reproduce log in with incorrect user")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldNotLogin() {
        loginPage.login("asdfasdf", "asdfasdfasdf");

        loginPage.checkErrorMessage();
    }

    @Test
    @DisplayName("Log out test")
    @Description("Test reproduce log out")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldLogOut() {
        loginPage.login("standard_user", "secret_sauce");

        loginPage.logOut();

        loginPage.checkLogOut();
    }
}
