import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class CheckoutPage extends HeaderElements {

    SelenideElement firstNameField = $("input#first-name");
    SelenideElement lastNameField = $("input#last-name");
    SelenideElement postalCodeField = $("input#postal-code");
    SelenideElement cancelButton = $("button#cancel");
    SelenideElement continueButton = $("input#continue");

    @Step("Fill user fields")
    public void fillUserFields() {
        firstNameField.setValue("Name");
        lastNameField.setValue("Name");
        postalCodeField.setValue("007007");
    }
    @Step("Click continue button")
    public void confirm() {
        continueButton.click();
    }
}
