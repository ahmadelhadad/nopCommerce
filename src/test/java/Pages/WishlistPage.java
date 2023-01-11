package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
    WebDriver driver = hooks.driver;
    public WishlistPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement WishlistHP(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[3]"));
    }
    public WebElement addToWishlistP(){
        return driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-4\"]"));
    }
    public WebElement FlashMsg(){
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
    }
    public void navigateToWishlist(){
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[1]")).click();
    }
    public WebElement Qty(){
        return driver.findElement(By.xpath("//*[@name=\"itemquantity11225\"]"));
    }
}
