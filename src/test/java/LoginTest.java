import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import utils.LoginPage;

import static com.codeborne.selenide.Selenide.*;


@DisplayName("Login Tests")
public class LoginTest {

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
    public void shouldLogin() {
        LoginPage lp = new LoginPage();
        lp.login("standard_user", "secret_sauce");

        Assertions.assertTrue(lp.getMenuButton().isDisplayed());
    }

    @Test
    @DisplayName("Login test with incorrect user")
    public void shouldNotLogin() {
        LoginPage lp = new LoginPage();
        lp.login("asdfasdf", "asdfasdfasdf");

        Assertions.assertTrue(lp.getErrorMessage().exists());
    }

    @Test
    @DisplayName("Log out test")
    public void shouldLogOut() {
        LoginPage lp = new LoginPage();
        lp.login("standard_user", "secret_sauce");

        lp.getMenuButton().should(Condition.appear).click();
        lp.getLogOutInMenu().should(Condition.appear).click();

        Assertions.assertTrue(lp.getLoginButton().isDisplayed());
    }
}
