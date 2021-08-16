import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CartPage {

    SelenideElement continueShoppingButton = $("button#continue-shopping");
    SelenideElement checkoutButton = $("button#checkout");
    List<SelenideElement> removeButtons = $$("button.cart_button");

    @Step("Remove last item from cart")
    public void removeLastItem() {
        removeButtons.get(removeButtons.size() - 1).click();
    }

    @Step("Click checkout button")
    public void checkout() {
        checkoutButton.click();
    }

    @Step("Get number of items")
    public int getNumberOfItems() {
        return removeButtons.size();
    }
}
