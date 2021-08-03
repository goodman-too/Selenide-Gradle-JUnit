import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import utils.*;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@DisplayName("Shopping tests")
public class ShoppingTest {

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


    @Test
    @DisplayName("Complete order test")
    public void shouldSuccessfulBuy() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addAllItemsToCart();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage = new CartPage();
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillUserFields();
        checkoutPage.getContinueButton().click();

        FinalCheckoutPage finalCheckoutPage = new FinalCheckoutPage();
        finalCheckoutPage.getFinishButton().click();

        finalCheckoutPage.getCompleteOrderElement().should(appear);
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", finalCheckoutPage.getCompleteOrderElement().getText());
    }

    @Test
    @DisplayName("Cancel order test")
    public void shouldCancelOrder() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addAllItemsToCart();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage = new CartPage();
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillUserFields();
        checkoutPage.getContinueButton().click();

        FinalCheckoutPage finalCheckoutPage = new FinalCheckoutPage();
        finalCheckoutPage.getCancelButton().click();

        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", WebDriverRunner.url());
    }

    @Test
    @DisplayName("Remove items from shopping cart test")
    public void shouldRemoveItemsFromCart() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addAllItemsToCart();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage = new CartPage();
        int numbersOfItemsBefore = cartPage.getRemoveButtons().size();
        cartPage.removeLastItem();
        int numbersOfItemsAfter = cartPage.getRemoveButtons().size();

        Assertions.assertEquals(numbersOfItemsBefore, (numbersOfItemsAfter+1));
    }

    @Test
    @DisplayName("Correct order sum test")
    public void shouldDisplayCorrectSumOnFinalCheckoutPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addAllItemsToCart();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage = new CartPage();
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillUserFields();
        checkoutPage.getContinueButton().click();

        FinalCheckoutPage finalCheckoutPage = new FinalCheckoutPage();

        Assertions.assertEquals(finalCheckoutPage.getTotalPrice(), finalCheckoutPage.getSumOfAllItems());
    }
}
