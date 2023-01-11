package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver = hooks.driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement addToCartHP(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]"));
    }
    public WebElement addToCartP(){
        return driver.findElement(By.cssSelector("#add-to-cart-button-4"));
    }
    public WebElement FlashMsg(){
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]"));
    }
    public void navigateToShoppingCart(){
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
    }
    public WebElement Qty(){
        return driver.findElement(By.xpath("//*[@id=\"itemquantity11224\"]"));
    }
}
