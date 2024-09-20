package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class productPage {
    WebDriver driver;

    public productPage(WebDriver driver) {
        this.driver = driver;
    }

    public void showTitle(String title){
        String actualTitle = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, actualTitle);
    }
    public void shouldShowSortBy(String sortBy){
        String actualSortBy = driver.findElement(By.cssSelector("[data-test='active-option']")).getText();
        assertEquals(sortBy, actualSortBy);
    }
    public void selectSortBy(String sortBy){
        WebElement selectElement = driver.findElement(By.cssSelector("[data-test='product-sort-container']"));
        Select sortByDropdown = new Select(selectElement);
        sortByDropdown.selectByVisibleText(sortBy);
    }

    public void showProductDetail(int productNo, String detail){
        List<WebElement> products = driver.findElements(By.cssSelector("[data-test='inventory-item']"));
        assertEquals(detail, products.get(productNo-1).getText());
    }

    public void clickAddToCartItemPrice(String price){
        List<WebElement> priceBars = driver.findElements(By.cssSelector("[class='pricebar']"));
        for (WebElement priceBar : priceBars) {
            if(priceBar.getText().equals(price + "\n" +
                    "Add to cart")){
                System.out.println(priceBar.getText());
                priceBar.click();
                break;
            }
        }
    }
}
