import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

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
        inventoryPage.openShoppingCart();

        cartPage.checkout();

        checkoutPage.fillUserFields();
        checkoutPage.confirm();

        finalCheckoutPage.finishOrder();

        //Asserts
        finalCheckoutPage.checkOrderConfirmation();
    }

    @Test
    @DisplayName("Cancel order")
    public void shouldCancelOrder() {
        //Preconditions
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addAllItemsToCart();
        inventoryPage.openShoppingCart();

        cartPage.checkout();

        checkoutPage.fillUserFields();
        checkoutPage.confirm();

        finalCheckoutPage.cancelOrder();

        //Asserts
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", WebDriverRunner.url());
    }

    @Test
    @DisplayName("Remove last item from shopping cart")
    public void shouldRemoveItemsFromCart() {
        //Preconditions
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addAllItemsToCart();
        inventoryPage.openShoppingCart();

        //Get data for assert
        int numberOfItemsBefore = cartPage.getNumberOfItems();
        cartPage.removeLastItem();
        int numberOfItemsAfter = cartPage.getNumberOfItems();

        //Asserts
        Assertions.assertEquals(numberOfItemsBefore, (numberOfItemsAfter+1));
    }

    @Test
    @DisplayName("Check correctness of sum on the final checkout page")
    public void shouldDisplayCorrectSumOnFinalCheckoutPage() {
        //Preconditions
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addAllItemsToCart();
        inventoryPage.openShoppingCart();

        cartPage.checkout();

        checkoutPage.fillUserFields();
        checkoutPage.confirm();

        //Asserts
        Assertions.assertEquals(finalCheckoutPage.getTotalPrice(), finalCheckoutPage.getSumOfAllItems());
    }
}
