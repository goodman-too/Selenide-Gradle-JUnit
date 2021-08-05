import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class HeaderElements {

    SelenideElement menuButton = $("button#react-burger-menu-btn");
    SelenideElement shoppingCartButton = $("a.shopping_cart_link");
    SelenideElement allItemsInMenu = $("a#inventory_sidebar_link");
    SelenideElement aboutInMenu = $("a#about_sidebar_link");
    SelenideElement logOutInMenu = $("a#logout_sidebar_link");
    SelenideElement resetAppInMenu = $("a#reset_sidebar_link");
    SelenideElement pageTitle = $("span.title");

    public void logOut() {
        menuButton.click();
        logOutInMenu.click();
    }

    public void openShoppingCart() {
        shoppingCartButton.click();
    }
}
