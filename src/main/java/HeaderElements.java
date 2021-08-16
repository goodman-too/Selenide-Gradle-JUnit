import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class HeaderElements {

    SelenideElement menuButton = $("button#react-burger-menu-btn");
    SelenideElement shoppingCartButton = $("a.shopping_cart_link");
    SelenideElement allItemsInMenu = $("a#inventory_sidebar_link");
    SelenideElement aboutInMenu = $("a#about_sidebar_link");
    SelenideElement logOutInMenu = $("a#logout_sidebar_link");
    SelenideElement resetAppInMenu = $("a#reset_sidebar_link");
    SelenideElement pageTitle = $("span.title");

    @Step("Log out")
    public void logOut() {
        menuButton.click();
        logOutInMenu.click();
    }

    @Step("Open shopping cart")
    public void openShoppingCart() {
        shoppingCartButton.click();
    }
}
