import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


@DisplayName("Login Tests")
public class LoginTest {

    LoginPage loginPage = new LoginPage();


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
        loginPage.login("standard_user", "secret_sauce");

        loginPage.checkLogIn();
    }

    @Test
    @DisplayName("Login test with incorrect user")
    public void shouldNotLogin() {
        loginPage.login("asdfasdf", "asdfasdfasdf");

        loginPage.checkErrorMessage();
    }

    @Test
    @DisplayName("Log out test")
    public void shouldLogOut() {
        loginPage.login("standard_user", "secret_sauce");

        loginPage.logOut();

        loginPage.checkLogOut();
    }
}
