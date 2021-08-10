package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Steps {

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void openPage(String url) {
        open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        String currentPageURL = getWebDriver().getCurrentUrl();
        assertEquals(url, currentPageURL);
    }

    @Тогда("^открывается страница \"([^\"]*)\"$")
    public void pageShouldOpened(String url) {
        String currentPageURL = getWebDriver().getCurrentUrl();
        assertEquals(url, currentPageURL);
    }

    @И("^имеется поле \"([^\"]*)\"$")
    public void fieldShouldExist(String placeholder) {
        $("input[placeholder='" + placeholder + "']").shouldBe(visible);
    }

    @И("^пользователь вводит логин \"([^\"]*)\"$")
    public void userEnterLogin(String login) {
        $("input#user-name").setValue(login);
    }


    @И("пользователь вводит пароль \"([^\"]*)\"$")
    public void userEnterPassword(String password) {
        $("input#password").setValue(password);
    }

    @И("пользователь нажимает кнопку \"([^\"]*)\"$")
    public void userClickButton(String value) {
        $("input[value='" + value + "']").click();
    }

    @Тогда("появляется ошибка авторизации")
    public void loginErrorMessageShouldExist() {
        $(By.xpath("//h3[@data-test=\"error\"]")).shouldBe(visible);
    }

    @И("пользователь нажимает кнопку меню")
    public void userClickMenuButton() {
        $("button#react-burger-menu-btn").click();
    }

    @И("пользователь нажимает кнопку LogOut")
    public void userClickLogoutButton() {
        $("a#logout_sidebar_link").click();
    }
}
