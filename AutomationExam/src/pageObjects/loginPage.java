package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUser(String user){
        driver.findElement(By.id("user-name")).sendKeys(user);
    }
    public void enterPass(String pass){
        driver.findElement(By.id("password")).sendKeys(pass);
    }
    public void clickLogin(){
        driver.findElement(By.id("login-button")).click();
    }
    public void shouldShowError(String error){
        String actualError = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(error, actualError);
    }
}
