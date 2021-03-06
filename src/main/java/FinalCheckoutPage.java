import com.codeborne.selenide.SelenideElement;

import java.math.BigDecimal;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class FinalCheckoutPage extends HeaderElements {

    SelenideElement cancelButton = $("button#cancel");
    SelenideElement finishButton = $("button#finish");
    SelenideElement itemTotalPrice = $("div.summary_subtotal_label");
    List<SelenideElement> itemsPrices = $$("div.inventory_item_price");
    SelenideElement completeOrderElement = $("h2.complete-header");


    public BigDecimal getTotalPrice() {
        return new BigDecimal(itemTotalPrice.getText().substring(13));
    }

    public BigDecimal getSumOfAllItems() {
        return itemsPrices.stream()
                .map(SelenideElement::getText)
                .map(s -> s.substring(1))
                .map(BigDecimal::new)
                .reduce(BigDecimal::add)
                .get();
    }

    public void finishOrder() {
        finishButton.click();
    }

    public void cancelOrder() {
        cancelButton.click();
    }

    public void checkOrderConfirmation() {
        completeOrderElement.shouldHave(text("THANK YOU FOR YOUR ORDER"));
    }

    public void checkOrderCanceling() {
        pageTitle.shouldHave(text("Products"));
    }
}
