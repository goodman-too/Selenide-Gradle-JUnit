import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.closeWebDriver;


@DisplayName("Shopping tests")
public class ShoppingTest {

    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    FinalCheckoutPage finalCheckoutPage = new FinalCheckoutPage();


    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


    @Test
    @DisplayName("Complete order")
    public void shouldSuccessfulBuy() {
        //Preconditions
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addAllItemsToCart();
        inventoryPage.shoppingCartButton.click();

        cartPage.checkoutButton.click();

        checkoutPage.fillUserFields();
        checkoutPage.continueButton.click();

        finalCheckoutPage.finishButton.click();

        //Asserts
        finalCheckoutPage.completeOrderElement.should(appear);
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", finalCheckoutPage.completeOrderElement.getText());
    }

    @Test
    @DisplayName("Cancel order")
    public void shouldCancelOrder() {
        //Preconditions
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addAllItemsToCart();
        inventoryPage.shoppingCartButton.click();

        cartPage.checkoutButton.click();

        checkoutPage.fillUserFields();
        checkoutPage.continueButton.click();

        finalCheckoutPage.cancelButton.click();

        //Asserts
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", WebDriverRunner.url());
    }

    @Test
    @DisplayName("Remove last item from shopping cart")
    public void shouldRemoveItemsFromCart() {
        //Preconditions
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addAllItemsToCart();
        inventoryPage.shoppingCartButton.click();

        //Get data for assert
        int numbersOfItemsBefore = cartPage.removeButtons.size();
        cartPage.removeLastItem();
        int numbersOfItemsAfter = cartPage.removeButtons.size();

        //Asserts
        Assertions.assertEquals(numbersOfItemsBefore, (numbersOfItemsAfter+1));
    }

    @Test
    @DisplayName("Check correctness of sum on the final checkout page")
    public void shouldDisplayCorrectSumOnFinalCheckoutPage() {
        //Preconditions
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addAllItemsToCart();
        inventoryPage.shoppingCartButton.click();

        cartPage.checkoutButton.click();

        checkoutPage.fillUserFields();
        checkoutPage.continueButton.click();

        //Asserts
        Assertions.assertEquals(finalCheckoutPage.getTotalPrice(), finalCheckoutPage.getSumOfAllItems());
    }
}
