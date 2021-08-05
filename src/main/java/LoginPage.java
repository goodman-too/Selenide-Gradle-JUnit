import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage extends HeaderElements {

    SelenideElement loginField = $("input#user-name");
    SelenideElement passwordField = $("input#password");
    SelenideElement loginButton = $("input#login-button");
    SelenideElement errorMessage = $(By.xpath("//h3[@data-test=\"error\"]"));

    public void login(String login, String password) {
        open("https://www.saucedemo.com/");
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }

    public void checkLogIn() {
        menuButton.shouldBe(visible);
    }

    public void checkLogOut() {
        loginField.shouldBe(visible);
    }

    public void checkErrorMessage() {
        errorMessage.shouldBe(visible);
    }
}
