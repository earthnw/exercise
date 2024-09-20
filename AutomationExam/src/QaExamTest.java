import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.*;

public class QaExamTest {

    private WebDriver driver;
    loginPage loginPage;
    headerBar headerBar;
    productPage productPage;
    yourCartPage yourCartPage;
    checkoutYourInfoPage checkoutYourInfoPage;
    checkoutOverviewPage checkoutOverviewPage;
    checkoutCompletePage checkoutCompletePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/niravitw/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new loginPage(driver);
        headerBar = new headerBar(driver);
        productPage = new productPage(driver);
        yourCartPage = new yourCartPage(driver);
        checkoutYourInfoPage = new checkoutYourInfoPage(driver);
        checkoutOverviewPage = new checkoutOverviewPage(driver);
        checkoutCompletePage = new checkoutCompletePage(driver);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("*** tear down ***");
        driver.quit();
    }

    @Test
    public void purchaseProductsComplete() {
        // 1. Validate that you’re logged in successfully.
        loginPage.enterUser("standard_user");
        loginPage.enterPass("secret_sauce");
        loginPage.clickLogin();

        // check details after login complete
        headerBar.showBurgerMenu();
        headerBar.showAppLogo("Swag Labs");
        headerBar.showCartIcon();

        productPage.showTitle("Products");
        productPage.shouldShowSortBy("Name (A to Z)");
        productPage.selectSortBy("Price (high to low)");

        // Check the product list after sorting by price.
        productPage.showProductDetail(1, "Sauce Labs Fleece Jacket\n" +
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.\n" +
                "$49.99\n" +
                "Add to cart");
        productPage.showProductDetail(2, "Sauce Labs Backpack\n" +
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n" +
                "$29.99\n" +
                "Add to cart");
        productPage.showProductDetail(3, "Sauce Labs Bolt T-Shirt\n" +
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.\n" +
                "$15.99\n" +
                "Add to cart");
        productPage.showProductDetail(4, "Test.allTheThings() T-Shirt (Red)\n" +
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.\n" +
                "$15.99\n" +
                "Add to cart");
        productPage.showProductDetail(5, "Sauce Labs Bike Light\n" +
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.\n" +
                "$9.99\n" +
                "Add to cart");
        productPage.showProductDetail(6, "Sauce Labs Onesie\n" +
                "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.\n" +
                "$7.99\n" +
                "Add to cart");

        // 3. Complete the purchase for 2 items which has $15.99 price.
        productPage.clickAddToCartItemPrice("$15.99");
        productPage.clickAddToCartItemPrice("$15.99");

        // check button should change to "Remove"
        productPage.showProductDetail(3, "Sauce Labs Bolt T-Shirt\n" +
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.\n" +
                "$15.99\n" +
                "Remove");
        productPage.showProductDetail(4, "Test.allTheThings() T-Shirt (Red)\n" +
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.\n" +
                "$15.99\n" +
                "Remove");

        // check total products in cart
        headerBar.showTotalCartBadge("2");

        headerBar.clickCartIcon();
        // check detail in Your Cart page
        yourCartPage.showTitle("Your Cart");
        yourCartPage.showProductDetail(1,"1\n" +
                "Sauce Labs Bolt T-Shirt\n" +
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.\n" +
                "$15.99\n" +
                "Remove");
        yourCartPage.showProductDetail(2,"1\n" +
                "Test.allTheThings() T-Shirt (Red)\n" +
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.\n" +
                "$15.99\n" +
                "Remove");
        yourCartPage.clickCheckout();

        checkoutYourInfoPage.showTitle("Checkout: Your Information");
        checkoutYourInfoPage.enterFirstName("niravit");
        checkoutYourInfoPage.enterLastName("worawarachai");
        checkoutYourInfoPage.enterPostalCode("11000");
        checkoutYourInfoPage.clickContinue();

        // 4. Log the checkout summary.

        // check overview detail
        checkoutOverviewPage.showTitle("Checkout: Overview");

        // check order detail
        checkoutOverviewPage.showProductDetail(1,"1\n" +
                "Sauce Labs Bolt T-Shirt\n" +
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.\n" +
                "$15.99");
        checkoutOverviewPage.showProductDetail(2,"1\n" +
                "Test.allTheThings() T-Shirt (Red)\n" +
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.\n" +
                "$15.99");

        // check payment info
        checkoutOverviewPage.showPaymentInfoLabel("Payment Information:");
        checkoutOverviewPage.showPaymentInfoValue("SauceCard #31337");

        // check shipping info
        checkoutOverviewPage.showShippingInfoLabel("Shipping Information:");
        checkoutOverviewPage.showShippingInfoValue("Free Pony Express Delivery!");

        // check price total
        checkoutOverviewPage.showPriceTotalLabel("Price Total");
        checkoutOverviewPage.showTotalPrice("Item total: $31.98");
        checkoutOverviewPage.showTax("Tax: $2.56");

        checkoutOverviewPage.showTotalPriceWithTax("Total: $34.54");

        checkoutOverviewPage.clickFinish();

        // check detail in Checkout: Complete! page
        checkoutCompletePage.showTitle("Checkout: Complete!");
        checkoutCompletePage.showCompleteHeader("Thank you for your order!");
        checkoutCompletePage.showCompleteText("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @Test
    public void loginWithLockedUser() {
        // 5. Validate the “locked_out_user” user.
        loginPage.enterUser("locked_out_user");
        loginPage.enterPass("secret_sauce");
        loginPage.clickLogin();

        // check error message after login by locked user
        loginPage.shouldShowError("Epic sadface: Sorry, this user has been locked out.");
    }
}
