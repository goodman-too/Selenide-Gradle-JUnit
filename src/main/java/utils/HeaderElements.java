package utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class HeaderElements {

    SelenideElement menuButton = $("button#react-burger-menu-btn");
    SelenideElement shoppingCartButton = $("a.shopping_cart_link");
    SelenideElement allItemsInMenu = $("a#inventory_sidebar_link");
    SelenideElement aboutInMenu = $("a#about_sidebar_link");
    SelenideElement logOutInMenu = $("a#logout_sidebar_link");
    SelenideElement resetAppInMenu = $("a#reset_sidebar_link");



    public SelenideElement getMenuButton() {
        return menuButton;
    }

    public SelenideElement getShoppingCartButton() {
        return shoppingCartButton;
    }

    public SelenideElement getAllItemsInMenu() {
        return allItemsInMenu;
    }

    public SelenideElement getAboutInMenu() {
        return aboutInMenu;
    }

    public SelenideElement getLogOutInMenu() {
        return logOutInMenu;
    }

    public SelenideElement getResetAppInMenu() {
        return resetAppInMenu;
    }
}
