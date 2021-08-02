package utils;

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


    public SelenideElement getFirstNameField() {
        return firstNameField;
    }

    public SelenideElement getLastNameField() {
        return lastNameField;
    }

    public SelenideElement getPostalCodeField() {
        return postalCodeField;
    }

    public SelenideElement getCancelButton() {
        return cancelButton;
    }

    public SelenideElement getContinueButton() {
        return continueButton;
    }
}
