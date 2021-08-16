import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage extends HeaderElements {

    SelenideElement loginField = $("input#user-name");
    SelenideElement passwordField = $("input#password");
    SelenideElement loginButton = $("input#login-button");
    SelenideElement errorMessage = $(By.xpath("//h3[@data-test=\"error\"]"));

    @Step("Log in")
    public void login(String login, String password) {
        open("https://www.saucedemo.com/");
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }

    @Step("Check log in")
    public void checkLogIn() {
        menuButton.shouldBe(visible);
    }

    @Step("Check log out")
    public void checkLogOut() {
        loginField.shouldBe(visible);
    }

    @Step("Check error message when incorrect user")
    public void checkErrorMessage() {
        errorMessage.shouldBe(visible);
    }
}
