package utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;


public class InventoryPage extends HeaderElements {


    public void addAllItemsToCart() {
        $$("button.btn_inventory ").forEach(SelenideElement::click);
    }
}
