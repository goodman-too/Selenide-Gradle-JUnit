import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CartPage {

    SelenideElement continueShoppingButton = $("button#continue-shopping");
    SelenideElement checkoutButton = $("button#checkout");
    List<SelenideElement> removeButtons = $$("button.cart_button");


    public void removeLastItem() {
        removeButtons.get(removeButtons.size() - 1).click();
    }
}
