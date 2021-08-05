import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class InventoryPage extends HeaderElements {

    SelenideElement addBackpackButton = $("add-to-cart-sauce-labs-backpack");
    SelenideElement addBikeLightButton = $("add-to-cart-sauce-labs-bike-light");
    SelenideElement addBoltTshirtButton = $("add-to-cart-sauce-labs-bolt-t-shirt");
    SelenideElement addJacketButton = $("add-to-cart-sauce-labs-fleece-jacket");
    SelenideElement addOnesieButton = $("add-to-cart-sauce-labs-onesie");
    SelenideElement addRedTshirtButton = $("add-to-cart-test.allthethings()-t-shirt-(red)");

    public void addAllItemsToCart() {
        $$("button.btn_inventory").forEach(SelenideElement::click);
    }
}
