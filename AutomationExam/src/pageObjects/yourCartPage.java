package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class yourCartPage {
    WebDriver driver;

    public yourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void showTitle(String title) {
        String actualTitle = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, actualTitle);
    }
    public void clickCheckout(){
        driver.findElement(By.id("checkout")).click();
    }
    public void showProductDetail(int productNo, String detail){
        List<WebElement> products = driver.findElements(By.cssSelector("[data-test='inventory-item']"));
        assertEquals(detail, products.get(productNo-1).getText());
    }


}
