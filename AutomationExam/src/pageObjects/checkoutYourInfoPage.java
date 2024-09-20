package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutYourInfoPage {
    WebDriver driver;

    public checkoutYourInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName){
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }
    public void enterPostalCode(String portalCode){
        driver.findElement(By.id("postal-code")).sendKeys(portalCode);
    }
    public void clickContinue(){
        driver.findElement(By.id("continue")).click();
    }

    public void showTitle(String title) {
        String actualTitle = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, actualTitle);
    }
}
