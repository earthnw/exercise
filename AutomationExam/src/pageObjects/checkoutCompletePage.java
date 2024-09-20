package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutCompletePage {
    WebDriver driver;

    public checkoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void showTitle(String title) {
        String actualTitle = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, actualTitle);
    }
    public void showCompleteHeader(String completeHeader) {
        String actualCompleteHeader = driver.findElement(By.cssSelector("[data-test='complete-header']")).getText();
        assertEquals(completeHeader, actualCompleteHeader);
    }
    public void showCompleteText(String completeText) {
        String actualCompleteText = driver.findElement(By.cssSelector("[data-test='complete-text']")).getText();
        assertEquals(completeText, actualCompleteText);
    }
}
