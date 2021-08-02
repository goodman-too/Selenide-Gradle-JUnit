package utils;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FinalCheckoutPage {

    SelenideElement cancelButton = $("button#cancel");
    SelenideElement finishButton = $("button#finish");
    SelenideElement itemTotalPrice = $("div.summary_subtotal_label");
    List<SelenideElement> itemsPrices = $$("div.inventory_item_price");


    public float getTotalPrice() {
        return Float.parseFloat(itemTotalPrice.getText().substring(13));
    }

    public float getSumOfAllItems() {
        return itemsPrices.stream()
                .map(SelenideElement::getText)
                .map(s -> s.substring(1))
                .map(Float::parseFloat)
                .reduce(Float::sum)
                .get();
    }
}
