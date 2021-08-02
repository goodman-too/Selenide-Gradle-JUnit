package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

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

    public SelenideElement getLoginField() {
        return loginField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }
}
