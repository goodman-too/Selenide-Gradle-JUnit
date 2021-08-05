import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class CheckoutPage extends HeaderElements {

    SelenideElement firstNameField = $("input#first-name");
    SelenideElement lastNameField = $("input#last-name");
    SelenideElement postalCodeField = $("input#postal-code");
    SelenideElement cancelButton = $("button#cancel");
    SelenideElement continueButton = $("input#continue");


    public void fillUserFields() {
        firstNameField.setValue("Name");
        lastNameField.setValue("Name");
        postalCodeField.setValue("007007");
    }

    public void confirm() {
        continueButton.click();
    }
}
