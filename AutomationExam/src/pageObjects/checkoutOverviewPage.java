package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutOverviewPage {
    WebDriver driver;

    public checkoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void showTitle(String title) {
        String actualTitle = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, actualTitle);
    }
    public void showProductDetail(int productNo, String detail) {
        List<WebElement> products = driver.findElements(By.cssSelector("[data-test='inventory-item']"));
        assertEquals(detail, products.get(productNo-1).getText());
    }

    public void showPaymentInfoLabel(String paymentInfoLabel) {
        String actualPaymentInfoLabel = driver.findElement(By.cssSelector("[data-test='payment-info-label']")).getText();
        assertEquals(paymentInfoLabel, actualPaymentInfoLabel);
    }
    public void showPaymentInfoValue(String paymentInfoValue) {
        String actualPaymentInfoValue = driver.findElement(By.cssSelector("[data-test='payment-info-value']")).getText();
        assertEquals(paymentInfoValue, actualPaymentInfoValue);
    }
    public void showShippingInfoLabel(String shippingInfoLabel) {
        String actualShippingInfoLabel = driver.findElement(By.cssSelector("[data-test='shipping-info-label']")).getText();
        assertEquals(shippingInfoLabel, actualShippingInfoLabel);
    }
    public void showShippingInfoValue(String shippingInfoValue) {
        String actualShippingInfoValue = driver.findElement(By.cssSelector("[data-test='shipping-info-value']")).getText();
        assertEquals(shippingInfoValue, actualShippingInfoValue);
    }
    public void showPriceTotalLabel(String priceTotalLabel) {
        String actualPriceTotalLabel = driver.findElement(By.cssSelector("[data-test='total-info-label']")).getText();
        assertEquals(priceTotalLabel, actualPriceTotalLabel);
    }
    public void showTotalPrice(String totalPrice) {
        String actualTotalPrice = driver.findElement(By.cssSelector("[data-test='subtotal-label']")).getText();
        assertEquals(totalPrice, actualTotalPrice);
    }
    public void showTax(String tax) {
        String actualTax = driver.findElement(By.cssSelector("[data-test='tax-label']")).getText();
        assertEquals(tax, actualTax);
    }
    public void showTotalPriceWithTax(String totalPriceWithTax) {
        String actualTotalPriceWithTax = driver.findElement(By.cssSelector("[data-test='total-label']")).getText();
        assertEquals(totalPriceWithTax, actualTotalPriceWithTax);
    }
    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }
}
