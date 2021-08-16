import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;


@Epic("saucedemo.com Tests")
@Feature("Shopping Tests")
@DisplayName("Shopping Tests")
public class ShoppingTest {

    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    FinalCheckoutPage finalCheckoutPage = new FinalCheckoutPage();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


    @Test
    @Disabled
    @DisplayName("Successful buy test")
    @Description("Test reproduce whole buying process")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Cancel order test")
    @Description("Test reproduce canceling order")
    @Severity(SeverityLevel.MINOR)
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
        finalCheckoutPage.checkOrderCanceling();
    }

    @Test
    @DisplayName("Remove last item test")
    @Description("Test remove last item from cart")
    @Severity(SeverityLevel.TRIVIAL)
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
        Assertions.assertEquals(numberOfItemsBefore, (numberOfItemsAfter + 1));
    }

    @Test
    @DisplayName("Check right sum of items")
    @Description("Check correctness of sum on the final checkout page")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("1179")
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
