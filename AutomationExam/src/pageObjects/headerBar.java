package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class headerBar {
    WebDriver driver;

    public headerBar(WebDriver driver) {
        this.driver = driver;
    }

    public void showBurgerMenu(){
        driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
    }
    public void showAppLogo(String appName){
        String logo = driver.findElement(By.className("app_logo")).getText();
        assertEquals(appName, logo);
    }
    public void clickCartIcon(){
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
    }
    public void showCartIcon(){
        driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).isDisplayed();
    }
    public void showTotalCartBadge(String totalProduct){
        String totalCartItems = driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']")).getText();
        assertEquals("2", totalCartItems);
    }
}
